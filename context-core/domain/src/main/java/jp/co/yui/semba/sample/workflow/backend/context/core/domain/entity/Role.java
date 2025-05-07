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

/** ロールマスタ */
@Value
@With
@Builder(toBuilder = true)
public class Role implements SoftDeletable {

  /** ロールID */
  Long roleId;

  /** 会社ID (NULL = 全社共通) */
  @Nullable Long companyId;

  /** ロールコード */
  String roleCode;

  /** ロール名称 */
  String roleName;

  /** ロール説明 */
  @Nullable String roleDesc;

  /** システムロール (1=システム) */
  boolean systemRole;

  /** 有効期間 */
  EffectivePeriod effectivePeriod;

  /** 削除日時 */
  @Nullable LocalDateTime deletedAt;

  /** {@inheritDoc} */
  @Override
  public Optional<LocalDateTime> getDeletedAt() {
    return Optional.ofNullable(deletedAt);
  }

  public Optional<Long> getCompanyId() {
    return Optional.ofNullable(companyId);
  }

  public Optional<String> getRoleDesc() {
    return Optional.ofNullable(roleDesc);
  }
}
