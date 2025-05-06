/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.kernel.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;

/** 実運用用 – OS 時刻をそのまま返すシングルトン */
public enum SystemLocalDateTimeProvider implements LocalDateTimeProvider {
  /** シングルトンインスタンス */
  INSTANCE;

  /** {@inheritDoc} */
  @Override
  public LocalDateTime now() {
    return LocalDateTime.now(ZoneId.systemDefault());
  }
}
