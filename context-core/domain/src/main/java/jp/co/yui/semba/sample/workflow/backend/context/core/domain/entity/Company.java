/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity;

import java.time.LocalDateTime;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.type.CountryCode;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.vo.EffectivePeriod;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.vo.PostalCode;
import jp.co.yui.semba.sample.workflow.backend.kernel.trait.SoftDeletable;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.springframework.lang.Nullable;

/** 会社エンティティ */
@Value
@With
@Builder(toBuilder = true)
public class Company implements SoftDeletable {

  /** 会社ID */
  Long companyId;

  /** 会社コード */
  String companyCode;

  /** 会社名 */
  String companyName;

  /** 登記上名称 */
  String legalName;

  /** 親会社ID */
  @Nullable Long parentCompanyId;

  /** 国コード */
  CountryCode countryCode;

  /** 郵便番号 */
  PostalCode postalCode;

  /** 住所1 */
  String addressLine1;

  /** 住所2 */
  @Nullable String addressLine2;

  /** 有効期間 */
  EffectivePeriod effectivePeriod;

  /** 削除日時 */
  @Nullable LocalDateTime deletedAt;

  /** {@inheritDoc} */
  @Override
  public Optional<LocalDateTime> getDeletedAt() {
    return Optional.ofNullable(deletedAt);
  }

  public Optional<Long> getParentCompanyId() {
    return Optional.ofNullable(parentCompanyId);
  }

  public Optional<String> getAddressLine2() {
    return Optional.ofNullable(addressLine2);
  }
}
