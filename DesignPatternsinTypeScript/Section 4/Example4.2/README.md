## Adapterパターン
    Adapterパターンを用いると、既存のクラスに対して修正を加えることなく、インタフェースを変更することができる。
    Adapterパターンを実現するための手法として継承を利用した手法と委譲を利用した手法が存在する。

# 継承を利用したAdapter
    利用したいクラスのサブクラスを作成し、そのサブクラスに対して必要なインタフェースを実装することで実現される。

# 委譲を利用したAdapter
    利用したいクラスのインスタンスを生成し、そのインスタンスを他クラスから利用することで実現される。

