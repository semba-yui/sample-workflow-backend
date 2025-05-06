# kernel

ドメイン境界: 会社・組織・従業員・ロールなど **マスタデータ** を扱う純粋 Domain レイヤ。

## 📦 パッケージ構成

```text
com.example.core.domain
├─ model          // VO / Entity
├─ repository     // Domain Port
└─ service        // Domain Service
```

## 🧪 テスト

```bash
./gradlew :kernel:test
```
