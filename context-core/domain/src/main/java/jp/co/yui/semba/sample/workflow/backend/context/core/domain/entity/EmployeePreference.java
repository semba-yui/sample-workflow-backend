/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity;

import java.time.LocalDateTime;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.type.DateFormat;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.type.NotifyType;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.type.UiTheme;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.vo.EffectivePeriod;
import jp.co.yui.semba.sample.workflow.backend.kernel.trait.SoftDeletable;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.springframework.lang.Nullable;

/** 従業員個人設定マスタ */
@Value
@With
@Builder(toBuilder = true)
public class EmployeePreference implements SoftDeletable {

  /** 従業員ID */
  Long empId;

  /** 言語・ロケール */
  String locale;

  /** タイムゾーン */
  String timezone;

  /** UI テーマ */
  UiTheme theme;

  /** 日付フォーマット */
  DateFormat dateFormat;

  /** 通知方法 */
  NotifyType notifyType;

  /** デフォルト原価センタ */
  @Nullable String defaultCostCenter;

  /** 申請時の CC メール */
  @Nullable String defaultCcEmail;

  /** 有効期間 */
  EffectivePeriod effectivePeriod;

  /** 削除日時 */
  @Nullable LocalDateTime deletedAt;

  /** {@inheritDoc} */
  @Override
  public Optional<LocalDateTime> getDeletedAt() {
    return Optional.ofNullable(deletedAt);
  }

  public Optional<String> getDefaultCostCenter() {
    return Optional.ofNullable(defaultCostCenter);
  }

  public Optional<String> getDefaultCcEmail() {
    return Optional.ofNullable(defaultCcEmail);
  }
}
