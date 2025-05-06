/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.vo;

import java.time.LocalDateTime;
import jp.co.yui.semba.sample.workflow.backend.kernel.datetime.LocalDateTimeProvider;

/**
 * 期間を表す値オブジェクト
 *
 * <ul>
 *   <li>from 以上、to 未満の半開区間で判定
 *   <li>from は必須、to は任意
 *   <li>to が未指定の場合は、9999-12-31 23:59:59 を指定したものとする
 * </ul>
 *
 * @param from 開始日時
 * @param to 終了日時
 */
public record EffectivePeriod(LocalDateTime from, LocalDateTime to) {

  /**
   * 終了日時が未指定の場合のデフォルト値
   *
   * <p>9999-12-31 23:59:59
   */
  public static final LocalDateTime FOREVER = LocalDateTime.of(9999, 12, 31, 23, 59, 59);

  /**
   * 「今から無期限」の生成ヘルパ
   *
   * @param provider 日時プロバイダ
   * @return 期間
   */
  public static EffectivePeriod openEnded(LocalDateTimeProvider provider) {
    return new EffectivePeriod(provider.now(), FOREVER);
  }

  /**
   * 指定日時が期間内か？
   *
   * @param when 判定日時
   * @return 期間内の場合: true / それ以外: false
   */
  public boolean contains(LocalDateTime when) {
    return (when.isEqual(from) || when.isAfter(from)) && when.isBefore(to);
  }
}
