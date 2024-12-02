package cn.edu.xmu.javaee.productdemoaop.mapper.join;

import cn.edu.xmu.javaee.productdemoaop.mapper.generator.po.OnSalePo;
import cn.edu.xmu.javaee.productdemoaop.mapper.generator.po.ProductPo;
import cn.edu.xmu.javaee.productdemoaop.mapper.join.po.ProductJoinPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface ProductJoinMapper {
    @Select("SELECT g.id AS g_id, g.name AS g_name, g.goods_id AS g_goods_id, g.category_id AS g_category_id, "
            + "g.template_id AS g_template_id, g.sku_sn AS g_sku_sn, g.original_price AS g_original_price, "
            + "g.weight AS g_weight, g.barcode AS g_barcode, g.unit AS g_unit, g.origin_place AS g_origin_place, "
            + "g.creator_id AS g_creator_id, g.creator_name AS g_creator_name, g.modifier_id AS g_modifier_id, "
            + "g.modifier_name AS g_modifier_name, g.gmt_create AS g_gmt_create, g.gmt_modified AS g_gmt_modified, "
            + "g.status AS g_status, g.commission_ratio AS g_commission_ratio, g.shop_logistic_id AS g_shop_logistic_id, "
            + "g.free_threshold AS g_free_threshold, "
            + "o.id AS o_id, o.shop_id AS o_shop_id, o.product_id AS o_product_id, o.price AS o_price, "
            + "o.begin_time AS o_begin_time, o.end_time AS o_end_time, o.quantity AS o_quantity, "
            + "o.type AS o_type, o.creator_id AS o_creator_id, o.creator_name AS o_creator_name, "
            + "o.modifier_id AS o_modifier_id, o.modifier_name AS o_modifier_name, "
            + "o.gmt_create AS o_gmt_create, o.gmt_modified AS o_gmt_modified, o.max_quantity AS o_max_quantity, "
            + "o.invalid AS o_invalid "
            + "FROM goods_product AS g "
            + "LEFT JOIN goods_onsale AS o ON g.id = o.product_id "
            + "WHERE g.name = #{name}")
    @Results({
            @Result(property = "id", column = "g_id", jdbcType = JdbcType.BIGINT),
            @Result(property = "name", column = "g_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "goodsId", column = "g_goods_id", jdbcType = JdbcType.BIGINT),
            @Result(property = "categoryId", column = "g_category_id", jdbcType = JdbcType.BIGINT),
            @Result(property = "templateId", column = "g_template_id", jdbcType = JdbcType.BIGINT),
            @Result(property = "skuSn", column = "g_sku_sn", jdbcType = JdbcType.VARCHAR),
            @Result(property = "originalPrice", column = "g_original_price", jdbcType = JdbcType.BIGINT),
            @Result(property = "weight", column = "g_weight", jdbcType = JdbcType.BIGINT),
            @Result(property = "barcode", column = "g_barcode", jdbcType = JdbcType.VARCHAR),
            @Result(property = "unit", column = "g_unit", jdbcType = JdbcType.VARCHAR),
            @Result(property = "originPlace", column = "g_origin_place", jdbcType = JdbcType.VARCHAR),
            @Result(property = "creatorId", column = "g_creator_id", jdbcType = JdbcType.BIGINT),
            @Result(property = "creatorName", column = "g_creator_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "modifierId", column = "g_modifier_id", jdbcType = JdbcType.BIGINT),
            @Result(property = "modifierName", column = "g_modifier_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "gmtCreate", column = "g_gmt_create", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "gmtModified", column = "g_gmt_modified", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "status", column = "g_status", jdbcType = JdbcType.TINYINT),
            @Result(property = "commissionRatio", column = "g_commission_ratio", jdbcType = JdbcType.INTEGER),
            @Result(property = "shopLogisticId", column = "g_shop_logistic_id", jdbcType = JdbcType.BIGINT),
            @Result(property = "freeThreshold", column = "g_free_threshold", jdbcType = JdbcType.BIGINT),
            @Result(property = "onSaleId", column = "o_id", jdbcType = JdbcType.BIGINT),
            @Result(property = "shopId", column = "o_shop_id", jdbcType = JdbcType.BIGINT),
            @Result(property = "productId", column = "o_product_id", jdbcType = JdbcType.BIGINT),
            @Result(property = "price", column = "o_price", jdbcType = JdbcType.BIGINT), // 修改为 BIGINT
            @Result(property = "beginTime", column = "o_begin_time", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "endTime", column = "o_end_time", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "quantity", column = "o_quantity", jdbcType = JdbcType.INTEGER),
            @Result(property = "type", column = "o_type", jdbcType = JdbcType.TINYINT),
            @Result(property = "creatorId", column = "o_creator_id", jdbcType = JdbcType.BIGINT),
            @Result(property = "creatorName", column = "o_creator_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "modifierId", column = "o_modifier_id", jdbcType = JdbcType.BIGINT),
            @Result(property = "modifierName", column = "o_modifier_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "gmtCreate", column = "o_gmt_create", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "gmtModified", column = "o_gmt_modified", jdbcType = JdbcType.TIMESTAMP),
            @Result(property = "maxQuantity", column = "o_max_quantity", jdbcType = JdbcType.INTEGER),
            @Result(property = "invalid", column = "o_invalid", jdbcType = JdbcType.TINYINT),

            @Result(property = "onSaleList", javaType = List.class, many = @Many(select="selectLastOnSaleByProductId"), column = "g_id"),
            @Result(property = "otherProduct", javaType = List.class, many = @Many(select="selectOtherProduct"), column = "g_goods_id")
    })
    List<ProductJoinPo> findProductByName_Join(@Param("name") String name);

    @Select("SELECT `id`, `product_id`, `price`, `begin_time`, `end_time`, `quantity`, `max_quantity`, "
            + "`creator_id`, `creator_name`, `modifier_id`, `modifier_name`, `gmt_create`, `gmt_modified` "
            + "FROM `goods_onsale` "
            + "WHERE `product_id` = #{productId,jdbcType=BIGINT} "
            + "AND `begin_time` <= NOW() "
            + "AND `end_time` > NOW()")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
            @Result(column="price", property="price", jdbcType=JdbcType.BIGINT),
            @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
            @Result(column="max_quantity", property="maxQuantity", jdbcType=JdbcType.INTEGER),
            @Result(column="creator_id", property="creatorId", jdbcType=JdbcType.BIGINT),
            @Result(column="creator_name", property="creatorName", jdbcType=JdbcType.VARCHAR),
            @Result(column="modifier_id", property="modifierId", jdbcType=JdbcType.BIGINT),
            @Result(column="modifier_name", property="modifierName", jdbcType=JdbcType.VARCHAR),
            @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OnSalePo> selectLastOnSaleByProductId(Long productId);

    @Select("SELECT `id`, `goods_id`, `sku_sn`, `name`, `original_price`, `weight`, "
            + "`barcode`, `unit`, `origin_place`, `creator_id`, `creator_name`, `modifier_id`, "
            + "`modifier_name`, `gmt_create`, `gmt_modified` "
            + "FROM `goods_product` "
            + "WHERE `goods_id` = #{goodsId,jdbcType=BIGINT}") // 根据 goodsId 查询
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="sku_sn", property="skuSn", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="original_price", property="originalPrice", jdbcType=JdbcType.BIGINT),
            @Result(column="weight", property="weight", jdbcType=JdbcType.BIGINT),
            @Result(column="barcode", property="barcode", jdbcType=JdbcType.VARCHAR),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
            @Result(column="origin_place", property="originPlace", jdbcType=JdbcType.VARCHAR),
            @Result(column="creator_id", property="creatorId", jdbcType=JdbcType.BIGINT),
            @Result(column="creator_name", property="creatorName", jdbcType=JdbcType.VARCHAR),
            @Result(column="modifier_id", property="modifierId", jdbcType=JdbcType.BIGINT),
            @Result(column="modifier_name", property="modifierName", jdbcType=JdbcType.VARCHAR),
            @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ProductPo> selectOtherProduct(Long goodsId);
}
