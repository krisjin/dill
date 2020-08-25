

搜索结果结果启发，改写查询

$a_i$

$w_0$

$W_{hi}$

$W_{ij}$



其中，vj,fvj,f 是隐向量 **v**jvj 的第 ff 个元素。由于 ∑nj=1vj,fxj∑j=1nvj,fxj 只与 ff 有关，而与 ii 无关，在每次迭代过程中，只需计算一次所有 ff 的 ∑nj=1vj,fxj∑j=1nvj,fxj，就能够方便地得到所有 vi,fvi,f 的梯度。显然，计算所有 ff 的 ∑nj=1vj,fxj∑j=1nvj,fxj 的复杂度是 O(kn)O(kn)；已知 ∑nj=1vj,fxj∑j=1nvj,fxj 时，计算每个参数梯度的复杂度是 O(1)O(1)；得到梯度后，更新每个参数的复杂度是 O(1)O(1)；模型参数一共有 nk+n+1nk+n+1 个。因此，FM参数训练的复杂度也是 O(kn)O(kn)。综上可知，FM可以在线性时间训练和预测，是一种非常高效的模型。



Buffer limit的作用，设置此缓冲区的限制，缓冲区的限制代表第一个不应该读取或写入元素的index





Clear方法的侧重点在于还原一切

rewind

flip

limit

position





\[ \sum_{i=1}^n \sum_{j=i+1}^n \langle \mathbf{v}_i, \mathbf{v}_j \rangle x_i x_j = \frac{1}{2} \sum_{f=1}^k \left(\left( \sum_{i=1}^n v_{i, f} x_i \right)^2 - \sum_{i=1}^n v_{i, f}^2 x_i^2 \right) \label{eq:fm_conv}\tag{3} \]



18446744073709551615

