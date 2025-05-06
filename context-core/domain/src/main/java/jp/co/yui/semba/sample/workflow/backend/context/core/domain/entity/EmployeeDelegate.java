/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity;

import java.time.LocalDateTime;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.type.DelegateMode;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.vo.EffectivePeriod;
import jp.co.yui.semba.sample.workflow.backend.kernel.trait.SoftDeletable;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.springframework.lang.Nullable;

/** 代理設定マスタ */
@Value
@With
@Builder(toBuilder = true)
public class EmployeeDelegate implements SoftDeletable {

  /** 代理シーケンスPK */
  Long delegateSeq;

  /** 本人 */
  Long empId;

  /** 代理人 */
  Long delegateId;

  /** ALL=全権委任, LIMITED=範囲指定 */
  DelegateMode mode;

  /** 有効期間 */
  EffectivePeriod effectivePeriod;

  /** 削除日時 */
  @Nullable LocalDateTime deletedAt;

  /** {@inheritDoc} */
  @Override
  public Optional<LocalDateTime> getDeletedAt() {
    return Optional.ofNullable(deletedAt);
  }
}
