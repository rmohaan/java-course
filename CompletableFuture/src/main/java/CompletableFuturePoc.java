import java.util.concurrent.CompletableFuture;

public class CompletableFuturePoc {

    private static Integer compute(int n) {
        return n * n;
    }

    private static CompletableFuture<Integer> createCompletableFutureCompute(int n) {
        return CompletableFuture.supplyAsync(() -> compute(n));
    }

    public static void main(String[] args) {
        createCompletableFutureCompute(10)
                .thenApply(d -> d + 10)
                .thenAccept(System.out::println);

        // combine two CompletableFutures
        var future1 = createCompletableFutureCompute(10);
        var future2 = createCompletableFutureCompute(20);
        future1.thenCombine(future2, (data1, data2) -> data1 + data2 + 1)
                .thenAccept(System.out::println);

        // Composing CompletableFutures - when the CF returns another CF
        createCompletableFutureCompute(10)
                .thenCompose(data -> createCompletableFutureCompute(data))
                .thenAccept(System.out::println);

        // wait for all CompletableFutures to complete
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2);
        allFutures.thenRun(() -> System.out.println("All futures completed"));

        //Exception handling
        createCompletableFutureCompute(10)
                .thenApply(data -> {
                    if (data == 100) {
                        throw new RuntimeException("Simulated exception");
                    }
                    return data + 10;
                })
                .exceptionally(ex -> {
                    System.out.println("Exception occurred: " + ex.getMessage());
                    return -1;
                })
                .thenAccept(System.out::println);
    }
}