/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity;

import java.time.LocalDateTime;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.type.EmployeeStatus;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.type.EmploymentType;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.vo.EffectivePeriod;
import jp.co.yui.semba.sample.workflow.backend.kernel.trait.SoftDeletable;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.springframework.lang.Nullable;

/** 従業員マスタ */
@Value
@With
@Builder(toBuilder = true)
public class Employee implements SoftDeletable {

  /** 従業員ID */
  Long empId;

  /** 会社ID */
  Long companyId;

  /** 所属組織ID */
  Long orgId;

  /** 役職ID */
  @Nullable Long positionId;

  /** 社員番号 */
  String empCode;

  /** Azure AD Object ID */
  @Nullable String azureAdObjectId;

  /** 姓 */
  String lastName;

  /** 名 */
  String firstName;

  /** 姓（カナ） */
  @Nullable String lastNameKana;

  /** 名（カナ） */
  @Nullable String firstNameKana;

  /** 雇用区分 */
  EmploymentType employmentType;

  /** 在籍ステータス */
  EmployeeStatus status;

  /** 社用メールアドレス */
  String email;

  /** 連絡先電話番号 */
  @Nullable String phoneNumber;

  /** 有効期間 */
  EffectivePeriod effectivePeriod;

  /** 削除日時 */
  @Nullable LocalDateTime deletedAt;

  /** {@inheritDoc} */
  @Override
  public Optional<LocalDateTime> getDeletedAt() {
    return Optional.ofNullable(deletedAt);
  }

  public Optional<Long> getPositionId() {
    return Optional.ofNullable(positionId);
  }

  public Optional<String> getAzureAdObjectId() {
    return Optional.ofNullable(azureAdObjectId);
  }

  public Optional<String> getLastNameKana() {
    return Optional.ofNullable(lastNameKana);
  }

  public Optional<String> getFirstNameKana() {
    return Optional.ofNullable(firstNameKana);
  }

  public Optional<String> getPhoneNumber() {
    return Optional.ofNullable(phoneNumber);
  }
}
