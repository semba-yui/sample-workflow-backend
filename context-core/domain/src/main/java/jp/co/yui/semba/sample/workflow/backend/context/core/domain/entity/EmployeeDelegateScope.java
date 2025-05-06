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

/** 代理範囲マスタ */
@Value
@With
@Builder(toBuilder = true)
public class EmployeeDelegateScope implements SoftDeletable {

  /** 代理範囲ID */
  Long scopeId;

  /** 代理設定ID */
  Long delegateSeq;

  /** 対象WFキー(NULL=全) */
  @Nullable String wfKey;

  /** ステップ番号(NULL=全) */
  @Nullable Short wfStepNo;

  /** 追加パーミッション(NULL=無指定) */
  @Nullable String permCode;

  /** 有効期間 */
  EffectivePeriod effectivePeriod;

  /** 削除日時 */
  @Nullable LocalDateTime deletedAt;

  /** {@inheritDoc} */
  @Override
  public Optional<LocalDateTime> getDeletedAt() {
    return Optional.ofNullable(deletedAt);
  }

  public Optional<String> getWfKey() {
    return Optional.ofNullable(wfKey);
  }

  public Optional<Short> getWfStepNo() {
    return Optional.ofNullable(wfStepNo);
  }

  public Optional<String> getPermCode() {
    return Optional.ofNullable(permCode);
  }
}
