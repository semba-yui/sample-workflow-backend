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

/** パーミッションマスタ */
@Value
@With
@Builder(toBuilder = true)
public class Permission implements SoftDeletable {

  /** パーミッションID */
  Long permId;

  /** 会社ID (NULL = 全社共通) */
  @Nullable Long companyId;

  /** 権限コード */
  String permCode;

  /** 権限名称 */
  String permName;

  /** 説明 */
  @Nullable String permDesc;

  /** 機能グループ */
  @Nullable String permGroup;

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

  public Optional<String> getPermDesc() {
    return Optional.ofNullable(permDesc);
  }

  public Optional<String> getPermGroup() {
    return Optional.ofNullable(permGroup);
  }
}
