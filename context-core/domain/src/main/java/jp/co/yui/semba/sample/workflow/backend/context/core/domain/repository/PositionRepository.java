/** © Yui Semba */
package jp.co.yui.semba.sample.workflow.backend.context.core.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import jp.co.yui.semba.sample.workflow.backend.context.core.domain.entity.Position;

/**
 * 役職リポジトリ
 *
 * <p>役職に関する永続化処理を行うインターフェース
 */
public interface PositionRepository {

  /**
   * 役職IDから役職を取得する
   *
   * @param positionId 役職ID
   * @return 役職
   */
  Optional<Position> findById(Long positionId);

  /**
   * 会社IDから役職リストを取得する
   *
   * @param companyId 会社ID
   * @return 役職リスト
   */
  List<Position> findByCompanyId(Long companyId);

  /**
   * 指定時点で有効な役職を取得する
   *
   * @param timestamp 検索日時
   * @return 有効な役職のリスト
   */
  List<Position> findActiveAt(LocalDateTime timestamp);

  /**
   * 指定時点で有効な特定会社の役職を取得する
   *
   * @param companyId 会社ID
   * @param timestamp 検索日時
   * @return 有効な役職のリスト
   */
  List<Position> findActiveAtByCompanyId(Long companyId, LocalDateTime timestamp);

  /**
   * 等級・序列から役職リストを取得する
   *
   * @param gradeLevel 等級・序列
   * @return 役職リスト
   */
  List<Position> findByGradeLevel(Short gradeLevel);

  /**
   * 管理職フラグで役職リストを取得する
   *
   * @param managerial 管理職フラグ
   * @return 役職リスト
   */
  List<Position> findByManagerial(boolean managerial);

  /**
   * 役職を保存する
   *
   * @param position 保存対象の役職
   * @return 保存された役職
   */
  Position save(Position position);

  /**
   * 役職を論理削除する
   *
   * @param position 削除対象の役職
   * @param at 削除日時
   * @return 削除された役職
   */
  default Position softDelete(Position position, LocalDateTime at) {
    return save(position.withDeletedAt(at));
  }
}
