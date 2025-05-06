/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity;

import java.time.LocalDateTime;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.type.AccountPurpose;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.type.AccountType;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.vo.EffectivePeriod;
import jp.co.yui.semba.sample.workflow.backend.kernel.trait.SoftDeletable;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.springframework.lang.Nullable;

/** 従業員振込口座マスタ */
@Value
@With
@Builder(toBuilder = true)
public class EmployeeAccount implements SoftDeletable {

  /** 口座ID */
  Long accountId;

  /** 従業員ID */
  Long empId;

  /** 銀行コード */
  String bankCode;

  /** 支店コード */
  String branchCode;

  /** 口座種別 */
  AccountType accountType;

  /** 口座番号 (7桁) */
  String accountNo;

  /** 口座名義 (カナ推奨) */
  String accountName;

  /** 通貨 (ISO 4217) */
  String currencyCode;

  /** 用途区分 */
  AccountPurpose purpose;

  /** 同一用途内での優先順位 (1=最優先) */
  byte priority;

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
