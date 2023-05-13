#include <stdio.h>
#include <string.h>
#include <stdint.h>

#define ROTRIGHT(word,bits) (((word) >> (bits)) | ((word) << (32-(bits))))
#define SHIFTRIGHT(word,bits) ((word) >> (bits))
#define CH(x,y,z) (((x) & (y)) ^ ((~(x)) & (z)))
#define MAJ(x,y,z) (((x) & (y)) ^ ((x) & (z)) ^ ((y) & (z)))
#define EP0(x) (ROTRIGHT(x,2) ^ ROTRIGHT(x,13) ^ ROTRIGHT(x,22))
#define EP1(x) (ROTRIGHT(x,6) ^ ROTRIGHT(x,11) ^ ROTRIGHT(x,25))
#define SIG0(x) (ROTRIGHT(x,7) ^ ROTRIGHT(x,18) ^ SHIFTRIGHT(x,3))
#define SIG1(x) (ROTRIGHT(x,17) ^ ROTRIGHT(x,19) ^ SHIFTRIGHT(x,10))
#define SHA256_BLOCK_SIZE 32 // SHA-256 outputs a 32-byte digest

void sha256(char *input, uint32_t *hash) {
	static const uint32_t k[] = {
    0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1,
    0x923f82a4, 0xab1c5ed5, 0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3,
    0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174, 0xe49b69c1, 0xefbe4786,
    0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
    0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147,
    0x06ca6351, 0x14292967, 0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13,
    0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85, 0xa2bfe8a1, 0xa81a664b,
    0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
    0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a,
    0x5b9cca4f, 0x682e6ff3, 0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208,
    0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2
};

uint32_t h[8] = {
    0x6a09e667, 0xbb67ae85, 0x3c6ef372, 0xa54ff53a, 0x510e527f, 0x9b05688c, 0x1f83d9ab, 0x5be0cd19
};

uint32_t w[64];
uint32_t a, b, c, d, e, f, g, h1, i, j, t1, t2;

int input_len = strlen(input);

int padded_len = ((input_len + 8) / 64 + 1) * 64;
uint8_t *padded_input = (uint8_t *) malloc(padded_len);
memset(padded_input, 0, padded_len);
memcpy(padded_input, input, input_len);
padded_input[input_len] = 0x80;

uint64_t bit_len = input_len * 8;
memcpy(padded_input + padded_len - 8, &bit_len, 8);

int num_blocks = padded_len / 64;
for (i = 0; i < num_blocks; i++) {
    for (j = 0; j < 16; j++) {
        w[j] = ((uint32_t) padded_input[i*64 + j*4] << 24) |
               ((uint32_t) padded_input[i*64 + j*4 + 1] << 16) |
               ((uint32_t) padded_input[i*64 + j*4 + 2] << 8) |
               ((uint32_t) padded_input[i*64 + j*4 + 3]);
    }
    for (j = 16; j < 64; j++) {
        w[j] = SIG1(w[j-2]) + w[j-7] + SIG0(w[j-15]) + w[j-16];
    }

    a = h[0];
    b = h[1];
    c = h[2];
    d = h[3];
    e = h[4];
    f = h[5];
    g = h[6];
    h1 = h[7];

    for (j = 0; j < 64; j++) {
        t1 = h1 + EP1(e) + CH(e, f, g) + k[j] + w[j];
        t2 = EP0(a) + MAJ(a, b, c);
        h1 = g;
        g = f;
        f = e;
        e = d + t1;
        d = c;
        c = b;
        b = a;
        a = t1 + t2;
    }

    h[0] += a;
    h[1] += b;
    h[2] += c;
    h[3] += d;
    h[4] += e;
    h[5] += f;
    h[6] += g;
    h[7] += h1;
}

free(padded_input);

memcpy(hash, h, sizeof(h));
}

int main() {
    char input[100];
    printf("Enter a string to hash: ");
    fgets(input, 100, stdin);
    input[strcspn(input, "\n")] = 0; // remove newline character
    
    unsigned char hash[SHA256_BLOCK_SIZE];
    sha256(input, hash);
    
    printf("Hash of \"%s\":\n", input);
    for (int i = 0; i < SHA256_BLOCK_SIZE; i++) {
        printf("%02x", hash[i]);
    }
    printf("\n");
    
    return 0;
}

