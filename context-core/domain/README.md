# core-domain

ドメイン境界: 会社・組織・従業員・ロールなど **マスタデータ** を扱う純粋 Domain レイヤ。

## 📦 パッケージ構成

```text
jp.co.yui.semba.sample.workflow.backend.context.core.domain
├─ entity       // Domain Entity
├─ repository   // Domain Port
├─ service      // Domain Service
├─ type         // Domain Types
└─ vo           // Domain Value Object
```

## 🧪 テスト

```bash
./gradlew :context-core:core-domain:test
```
