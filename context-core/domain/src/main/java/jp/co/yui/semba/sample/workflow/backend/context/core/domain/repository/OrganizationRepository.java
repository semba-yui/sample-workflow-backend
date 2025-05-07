/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity.Organization;

/**
 * 組織リポジトリ
 *
 * <p>組織に関する永続化処理を行うインターフェース
 */
public interface OrganizationRepository {

  /**
   * 組織IDから組織を取得する
   *
   * @param orgId 組織ID
   * @return 組織
   */
  Optional<Organization> findById(Long orgId);

  /**
   * 組織コードから組織を取得する
   *
   * @param orgCode 組織コード
   * @return 組織
   */
  Optional<Organization> findByCode(String orgCode);

  /**
   * 会社IDに紐づく組織を取得する
   *
   * @param companyId 会社ID
   * @return 組織のリスト
   */
  List<Organization> findByCompanyId(Long companyId);

  /**
   * 指定時点で有効な組織を取得する
   *
   * @param timestamp 検索日時
   * @return 有効な組織のリスト
   */
  List<Organization> findActiveAt(LocalDateTime timestamp);

  /**
   * 組織を保存する
   *
   * @param organization 保存対象の組織
   * @return 保存された組織
   */
  Organization save(Organization organization);

  /**
   * 組織を論理削除する
   *
   * @param organization 削除対象の組織
   * @param at 削除日時
   * @return 削除された組織
   */
  default Organization softDelete(Organization organization, LocalDateTime at) {
    return save(organization.withDeletedAt(at));
  }
}
