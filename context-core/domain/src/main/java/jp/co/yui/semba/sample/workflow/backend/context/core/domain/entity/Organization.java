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

/** 組織マスタ */
@Value
@With
@Builder(toBuilder = true)
public class Organization implements SoftDeletable {

  /** 組織ID */
  Long orgId;

  /** 会社ID */
  Long companyId;

  /** 上位組織ID */
  @Nullable Long parentOrgId;

  /** 組織コード */
  String orgCode;

  /** 組織名称 */
  String orgName;

  /** 有効期間 */
  EffectivePeriod effectivePeriod;

  /** 削除日時 */
  @Nullable LocalDateTime deletedAt;

  /** {@inheritDoc} */
  @Override
  public Optional<LocalDateTime> getDeletedAt() {
    return Optional.ofNullable(deletedAt);
  }

  public Optional<Long> getParentOrgId() {
    return Optional.ofNullable(parentOrgId);
  }
}
