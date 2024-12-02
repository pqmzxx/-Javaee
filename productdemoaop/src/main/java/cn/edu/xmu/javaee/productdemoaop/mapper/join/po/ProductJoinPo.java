package cn.edu.xmu.javaee.productdemoaop.mapper.join.po;

import cn.edu.xmu.javaee.productdemoaop.mapper.generator.po.OnSalePo;
import cn.edu.xmu.javaee.productdemoaop.mapper.generator.po.ProductPo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductJoinPo {

    // 商品表中的字段
    private Long id;

    private String name;

    private Long goodsId;

    private Long productId;

    private Long categoryId;

    private Long templateId;        // 模板ID
    private String skuSn;           // SKU编号
    private Long originalPrice;     // 原价
    private Long weight;            // 重量
    private String barcode;         // 条形码
    private String unit;            // 单位
    private String originPlace;     // 产地
    private Long creatorId;         // 创建者ID
    private String creatorName;     // 创建者名称
    private Long modifierId;        // 修改者ID
    private String modifierName;    // 修改者名称
    private LocalDateTime gmtCreate; // 创建时间
    private LocalDateTime gmtModified; // 修改时间
    private Byte status;            // 状态
    private Integer commissionRatio; // 佣金比例
    private Long shopLogisticId;    // 商店物流ID
    private Long freeThreshold;      // 免邮门槛

    // 价格与数量表中的字段
    private Long onSaleId;          // 价格与数量ID
    private Long shopId;            // 商店ID
    private Long price;             // 售价
    private LocalDateTime beginTime; // 开始时间
    private LocalDateTime endTime;   // 结束时间
    private Integer quantity;        // 数量
    private Byte type;              // 类型
    private Integer maxQuantity;     // 最大数量
    private Byte invalid;           // 是否无效

    // 其他字段
    private List<OnSalePo> onSaleList = new ArrayList<>();
    private List<ProductPo> otherProduct = new ArrayList<>();
}