// Encrypts a string payload using a PEM public key and RSA-OAEP (SHA-256)
async function encryptPayload(payload, publicKeyPem) {
    const pemHeader = "-----BEGIN PUBLIC KEY-----";
    const pemFooter = "-----END PUBLIC KEY-----";
    let pem = publicKeyPem.trim().replace(pemHeader, "").replace(pemFooter, "").replace(/\s+/g, "");
    const binaryDerString = atob(pem);
    const binaryDer = new Uint8Array([...binaryDerString].map(char => char.charCodeAt(0)));
    const cryptoKey = await window.crypto.subtle.importKey(
        "spki",
        binaryDer.buffer,
        { name: "RSA-OAEP", hash: "SHA-256" },
        false,
        ["encrypt"]
    );
    const encoder = new TextEncoder();
    const data = encoder.encode(payload);
    const encrypted = await window.crypto.subtle.encrypt(
        { name: "RSA-OAEP" },
        cryptoKey,
        data
    );
    return btoa(String.fromCharCode(...new Uint8Array(encrypted)));
}

// Usage example
fetch('/public_key.pem')
    .then(response => response.text())
    .then(publicKeyPem => encryptPayload("your message", publicKeyPem))
    .then(encrypted => console.log("Encrypted payload:", encrypted))
    .catch(error => console.error("Encryption error:", error));