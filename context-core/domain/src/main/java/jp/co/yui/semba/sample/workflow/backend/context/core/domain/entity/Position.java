/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity;

import java.time.LocalDateTime;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.vo.EffectivePeriod;
import jp.co.yui.semba.sample.workflow.backend.kernel.trait.SoftDeletable;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.springframework.lang.Nullable;

/** 役職マスタ */
@Value
@With
@Builder(toBuilder = true)
public class Position implements SoftDeletable {

  /** 役職ID */
  Long positionId;

  /** 上位役職ID */
  @Nullable Long parentPositionId;

  /** 会社ID */
  Long companyId;

  /** 役職名称 */
  String positionName;

  /** 等級・序列（数値が小さいほど上位） */
  Short gradeLevel;

  /** 管理職フラグ */
  boolean managerial;

  /** 有効期間 */
  EffectivePeriod effectivePeriod;

  /** 削除日時 */
  @Nullable LocalDateTime deletedAt;

  /** {@inheritDoc} */
  @Override
  public Optional<LocalDateTime> getDeletedAt() {
    return Optional.ofNullable(deletedAt);
  }

  public Optional<Long> getParentPositionId() {
    return Optional.ofNullable(parentPositionId);
  }
}
