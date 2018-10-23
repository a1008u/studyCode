## The Object Pool
Object poolingの目的は複数のオブジェクトを作成と破壊することを防ぐ
作成したオブジェクトを削除しないで、再利用します。

## 利用理由
Objectを作成することと削除することはつまりメモリを割り当てること（allocate memory）とメモリを割り当て取り消すことだ（deallocate memory）。
このような動作を複数実行したら、パフォーマンスは遅くになります。
削除するかわりに、再利用します。