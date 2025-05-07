/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity.Company;

/**
 * 会社リポジトリ
 *
 * <p>会社に関する永続化処理を行うインターフェース
 */
public interface CompanyRepository {

  /**
   * 会社IDから会社を取得する
   *
   * @param companyId 会社ID
   * @return 会社
   */
  Optional<Company> findById(Long companyId);

  /**
   * 会社コードから会社を取得する
   *
   * @param companyCode 会社コード
   * @return 会社
   */
  Optional<Company> findByCode(String companyCode);

  /**
   * 指定時点で有効な会社を取得する
   *
   * @param timestamp 検索日時
   * @return 有効な会社のリスト
   */
  List<Company> findActiveAt(LocalDateTime timestamp);

  /**
   * 会社を保存する
   *
   * @param company 保存対象の会社
   * @return 保存された会社
   */
  Company save(Company company);

  /**
   * 会社を論理削除する
   *
   * @param company 削除対象の会社
   * @param at 削除日時
   * @return 削除された会社
   */
  default Company softDelete(Company company, LocalDateTime at) {
    return save(company.withDeletedAt(at));
  }
}
