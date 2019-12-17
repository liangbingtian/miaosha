create database yt_piaoeda_input_tax;

use yt_piaoeda_input_tax;


# Dump of table invoice
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `PK_INVOICE` int(11) NOT NULL AUTO_INCREMENT COMMENT '发票索引号',
  `FP_DM` char(12) NOT NULL COMMENT '发票代码，必填',
  `FP_HM` char(8) NOT NULL COMMENT '发票号码，必填',
  `JQBH` char(12) DEFAULT NULL COMMENT '税控设备编号，必填',
  `KPRQ` date DEFAULT NULL COMMENT '开票日期，YYYYMMDD，必填',
  `FP_MW` varchar(200) DEFAULT NULL COMMENT '发票密文',
  `JYM` char(20) DEFAULT NULL COMMENT '发票校验码，必填',
  `KPLX` char(1) NOT NULL COMMENT '开票类型\\n0-蓝字发票;1-红字发票',
  `FPJZ` char(1) DEFAULT '0' COMMENT '开票介质 0-电子发票；1-纸质发票',
  `ZFBZ` char(1) DEFAULT 'N' COMMENT '作废标志',
  `XSF_NSRSBH` char(20) NOT NULL COMMENT '销售方纳税人识别号，必填',
  `XSF_MC` varchar(100) NOT NULL COMMENT '销售方名称，必填。默认值：销售方',
  `XSF_DZDH` varchar(100) DEFAULT NULL COMMENT '销售方地址、电话',
  `XSF_YHZH` varchar(100) DEFAULT NULL COMMENT '销售方银行账号',
  `GMF_NSRSBH` char(20) DEFAULT NULL COMMENT '购买方纳税人识别号',
  `GMF_MC` varchar(100) NOT NULL COMMENT '购买方名称，必填，默认值：购买方',
  `GMF_DZDH` varchar(100) DEFAULT NULL COMMENT '购买方地址、电话',
  `GMF_YHZH` varchar(100) DEFAULT NULL COMMENT '购买方银行账号',
  `KPR` varchar(20) DEFAULT NULL COMMENT '开票人',
  `SKR` varchar(20) DEFAULT NULL COMMENT '收款人',
  `FHR` varchar(20) DEFAULT NULL COMMENT '复核人',
  `YFP_DM` char(12) DEFAULT NULL COMMENT '原发票代码（红字发票必须）',
  `YFP_HM` char(8) DEFAULT NULL COMMENT '原发票代码（红字发票必须）',
  `JSHJ` decimal(15,2) NOT NULL COMMENT '价税合计-单位：元（2位小数）',
  `HJJE` decimal(15,2) NOT NULL COMMENT '合计金额',
  `HJSE` decimal(15,2) DEFAULT NULL COMMENT '合计税额',
  `FPLX` varchar(4) NOT NULL COMMENT '发票类型1增值税电子普通发票;3增值税普通发票;4增值税专用发票;5机动车销售统一发票;6货物运输业增值税专用发票;14通行费发票;8成品油电子发票',
  `ZSFS` varchar(1) DEFAULT '0' COMMENT '征税方式',
  `BZ` varchar(256) DEFAULT NULL COMMENT '备注',
  `SWJGDM` varchar(20) DEFAULT NULL COMMENT '主管税务机关代码(机动车用)',
  `SWJGMC` varchar(200) DEFAULT NULL COMMENT '主管税务机关名称(机动车用)',
  `WSPZH` varchar(32) DEFAULT NULL COMMENT '完税凭证号(机动车用)',
  `TIMESTAMP` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳，格式YYYYMMDDHHMMSS',
  `FILEPATH` varchar(200) DEFAULT NULL,
  `SGBZ` varchar(1) DEFAULT NULL COMMENT '农产品收购标志；2=农产品收购',
  `TXFBZ` varchar(2) DEFAULT NULL COMMENT '通行费标志 06-可抵扣通行费 07-不可抵扣同行费',
  `LSLBZ` varchar(1) DEFAULT NULL COMMENT '通行费-零税率标志 空-非零税率 1-免税 2-不征收 3-零税率',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `verifystatus` int(11) DEFAULT NULL COMMENT '0-为查验 1-已查验',
  PRIMARY KEY (`PK_INVOICE`) USING BTREE,
  UNIQUE KEY `invoice_dm_hm` (`FP_HM`,`FP_DM`) USING BTREE,
  KEY `invoice_ydm_yhm` (`YFP_HM`,`YFP_DM`) USING BTREE,
  KEY `idx_kprq` (`KPRQ`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT=' 电子发票主表';



# Dump of table invoice_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_detail`;

CREATE TABLE `invoice_detail` (
  `PK_INVOICE_DETAIL` int(11) NOT NULL AUTO_INCREMENT,
  `PK_INVOICE` int(16) NOT NULL,
  `FP_DM` char(12) NOT NULL COMMENT '发票代码',
  `FP_HM` char(8) NOT NULL COMMENT '发票号码',
  `FPHXZ` char(1) NOT NULL COMMENT '发票行性质-0正常行/1折扣行/2被折扣行',
  `XMMC` varchar(90) NOT NULL COMMENT '项目名称',
  `DW` varchar(20) DEFAULT NULL COMMENT '计量单位',
  `GGXH` varchar(100) DEFAULT NULL COMMENT '规格型号',
  `XMSL` decimal(15,6) DEFAULT NULL COMMENT '项目数量',
  `XMDJ` decimal(20,10) DEFAULT NULL COMMENT '项目单价',
  `XMJE` decimal(15,2) NOT NULL COMMENT '项目金额',
  `SL` decimal(6,6) DEFAULT NULL COMMENT '税率',
  `SE` decimal(15,2) DEFAULT NULL COMMENT '税额',
  `KCE` decimal(15,2) DEFAULT NULL COMMENT '扣除额',
  `SPBM` varchar(19) DEFAULT NULL COMMENT '商品税收分类编码字段',
  `TXF_CPH` varchar(40) DEFAULT NULL COMMENT '通行费-车牌号',
  `TXF_LX` varchar(32) DEFAULT NULL COMMENT '通行费-类型',
  `TXF_TXRQQ` varchar(32) DEFAULT NULL COMMENT '通行费-通行日期起',
  `TXF_TXRQZ` varchar(32) DEFAULT NULL COMMENT '通行费-通行日期止',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`PK_INVOICE_DETAIL`) USING BTREE,
  KEY `parent_invoice` (`PK_INVOICE`) USING BTREE,
  KEY `idx_detail_hmdm` (`FP_HM`,`FP_DM`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='电子发票项目明细';



# Dump of table invoice_ext
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_ext`;

CREATE TABLE `invoice_ext` (
  `pk_invoice` int(11) NOT NULL COMMENT '主键',
  `authcode` varchar(32) DEFAULT NULL COMMENT '授权码',
  `authpwd` varchar(4) DEFAULT NULL COMMENT '授权码密码',
  `authtime` varchar(20) DEFAULT NULL,
  `idownloadcount` int(11) DEFAULT NULL COMMENT '下载次数',
  `sellerstatus` int(11) DEFAULT '-1' COMMENT '销售方发票状态',
  `purchaserstatus` int(11) DEFAULT '-1' COMMENT '购买方发票状态',
  `bred` char(1) DEFAULT 'N' COMMENT '是否被红冲',
  `issuspect` char(1) DEFAULT 'N' COMMENT '是否问题票',
  `issample` char(1) DEFAULT 'N' COMMENT '是否样票',
  `classification` varchar(15) DEFAULT '其他' COMMENT '发票分类',
  `card_id` varchar(32) DEFAULT NULL COMMENT '发票 id',
  `encrypt_code` varchar(200) DEFAULT NULL COMMENT '加密 code ',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`pk_invoice`) USING BTREE,
  KEY `idx_invoice_authcode` (`authcode`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;



# Dump of table reimburse_collection
# ------------------------------------------------------------

DROP TABLE IF EXISTS `reimburse_collection`;

CREATE TABLE `reimburse_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `pk_invoice` int(11) NOT NULL COMMENT '发票id',
  `fp_dm` varchar(12) DEFAULT NULL COMMENT '发票代码',
  `fp_hm` varchar(8) DEFAULT NULL COMMENT '发票号码',
  `submitter` varchar(50) DEFAULT NULL COMMENT '提交人（员工账号）',
  `submit_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `reimburse_user` varchar(50) DEFAULT NULL COMMENT '报销人',
  `reimburse_date` timestamp NULL DEFAULT NULL COMMENT '报销日期',
  `reimburse_money` decimal(15,2) DEFAULT NULL COMMENT '报销金额(2位小数)',
  `voucherid` varchar(32) DEFAULT NULL COMMENT '凭证号',
  `account_user` varchar(50) DEFAULT NULL COMMENT '记账人',
  `account_time` datetime DEFAULT NULL COMMENT '记账时间',
  `account_note` varchar(100) DEFAULT NULL COMMENT '记账备注',
  `vnote` varchar(181) DEFAULT NULL COMMENT '备注',
  `src_type` tinyint(4) DEFAULT '1' COMMENT '来源类型 1:手工界面上传；2:外系统接口调用',
  `payment_status` tinyint(4) DEFAULT '1' COMMENT '支付状态;1:未支付，2：已支付',
  `need_verify` char(1) DEFAULT NULL COMMENT '是否需要认证；N-不需要认证，Y-需要认证；专票使用',
  `src_billtype` varchar(10) DEFAULT NULL COMMENT '来源单据类型',
  `src_billcode` varchar(30) DEFAULT NULL COMMENT '来源单据号',
  `manual_verify_status` tinyint(4) DEFAULT NULL COMMENT '手工认证状态；1-不需认证；2-未勾选；3-已勾选；4-已认证',
  `bratio` varchar(1) DEFAULT 'N' COMMENT '是否比例转出',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_dm_hm` (`fp_dm`,`fp_hm`) USING BTREE,
  KEY `idx_corp_org_invoice` (`orgid`,`pk_invoice`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='报销台账';



# Dump of table verify_history
# ------------------------------------------------------------

DROP TABLE IF EXISTS `verify_history`;

CREATE TABLE `verify_history` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '企业ID',
  `orgid` int(10) unsigned NOT NULL COMMENT '受票组织ID',
  `fp_dm` char(12) NOT NULL COMMENT '发票代码',
  `fp_hm` char(8) NOT NULL COMMENT '发票号码',
  `result_code` varchar(10) NOT NULL COMMENT '查验结果编码',
  `result_msg` varchar(200) DEFAULT NULL COMMENT '查验结果',
  `userid` varchar(64) DEFAULT NULL COMMENT '查验人ID',
  `username` varchar(64) DEFAULT NULL COMMENT '查验人名称',
  `verify_type` tinyint(4) NOT NULL DEFAULT '2' COMMENT '查验方式 1-APP 2-扫码枪',
  `verify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '查验时间',
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_vrfy_org` (`corpid`,`orgid`) USING BTREE,
  KEY `idx_vrfy_dm_hm` (`fp_dm`,`fp_hm`) USING BTREE,
  KEY `idx_vrfy_dt` (`verify_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='查验历史记录';


/*插入数据*/
insert into yt_piaoeda_input_tax.invoice(`PK_INVOICE`, `FP_DM`, `FP_HM`, `JQBH`, `KPRQ`, `FP_MW`, `JYM`, `KPLX`, `FPJZ`, `ZFBZ`, `XSF_NSRSBH`, `XSF_MC`, `XSF_DZDH`, `XSF_YHZH`, `GMF_NSRSBH`, `GMF_MC`, `GMF_DZDH`, `GMF_YHZH`, `KPR`, `SKR`, `FHR`, `YFP_DM`, `YFP_HM`, `JSHJ`, `HJJE`, `HJSE`, `FPLX`, `ZSFS`, `BZ`, `SWJGDM`, `SWJGMC`, `WSPZH`, `TIMESTAMP`, `FILEPATH`, `SGBZ`, `TXFBZ`, `LSLBZ`, `createtime`, `verifystatus`) (select `PK_INVOICE`, `FP_DM`, `FP_HM`, `JQBH`, `KPRQ`, `FP_MW`, `JYM`, `KPLX`, `FPJZ`, `ZFBZ`, `XSF_NSRSBH`, `XSF_MC`, `XSF_DZDH`, `XSF_YHZH`, `GMF_NSRSBH`, `GMF_MC`, `GMF_DZDH`, `GMF_YHZH`, `KPR`, `SKR`, `FHR`, `YFP_DM`, `YFP_HM`, `JSHJ`, `HJJE`, `HJSE`, `FPLX`, `ZSFS`, `BZ`, `SWJGDM`, `SWJGMC`, `WSPZH`, `TIMESTAMP`, `FILEPATH`, `SGBZ`, `TXFBZ`, `LSLBZ`, `createtime`, `verifystatus`
from yt_piaoeda_piaoeda_client.invoice where yt_piaoeda_piaoeda_client.invoice.pk_invoice in (select yt_piaoeda_piaoeda_client.reimburse_collection.PK_INVOICE from yt_piaoeda_piaoeda_client.reimburse_collection));

insert into yt_piaoeda_input_tax.invoice_detail(`PK_INVOICE_DETAIL`, `PK_INVOICE`, `FP_DM`, `FP_HM`, `FPHXZ`, `XMMC`, `DW`, `GGXH`, `XMSL`, `XMDJ`, `XMJE`, `SL`, `SE`, `KCE`, `SPBM`, `TXF_CPH`, `TXF_LX`, `TXF_TXRQQ`, `TXF_TXRQZ`, `createtime`, `ts`) (select `PK_INVOICE_DETAIL`, `PK_INVOICE`, `FP_DM`, `FP_HM`, `FPHXZ`, `XMMC`, `DW`, `GGXH`, `XMSL`, `XMDJ`, `XMJE`, `SL`, `SE`, `KCE`, `SPBM`, `TXF_CPH`, `TXF_LX`, `TXF_TXRQQ`, `TXF_TXRQZ`, `createtime`, `ts` from yt_piaoeda_piaoeda_client.invoice_detail where yt_piaoeda_piaoeda_client.invoice_detail.pk_invoice in (select yt_piaoeda_piaoeda_client.reimburse_collection.PK_INVOICE from yt_piaoeda_piaoeda_client.reimburse_collection));

insert into yt_piaoeda_input_tax.invoice_ext(`pk_invoice`, `authcode`, `authpwd`, `authtime`, `idownloadcount`, `sellerstatus`, `purchaserstatus`, `bred`, `issuspect`, `issample`, `classification`, `card_id`, `encrypt_code`, `createtime`, `ts`) (select `pk_invoice`, `authcode`, `authpwd`, `authtime`, `idownloadcount`, `sellerstatus`, `purchaserstatus`, `bred`, `issuspect`, `issample`, `classification`, `card_id`, `encrypt_code`, `createtime`, `ts`
from yt_piaoeda_piaoeda_client.invoice_ext where yt_piaoeda_piaoeda_client.invoice_ext.pk_invoice in (select yt_piaoeda_piaoeda_client.reimburse_collection.PK_INVOICE from yt_piaoeda_piaoeda_client.reimburse_collection));

insert into yt_piaoeda_input_tax.reimburse_collection(`id`, `corpid`, `orgid`, `pk_invoice`, `fp_dm`, `fp_hm`, `submitter`, `submit_date`, `reimburse_user`, `reimburse_date`, `reimburse_money`, `voucherid`, `account_user`, `account_time`, `account_note`, `vnote`, `src_type`, `payment_status`, `need_verify`, `src_billtype`, `src_billcode`, `manual_verify_status`, `bratio`, `ts`, `createtime`) (select `id`, `corpid`, `orgid`, `pk_invoice`, `fp_dm`, `fp_hm`, `submitter`, `submit_date`, `reimburse_user`, `reimburse_date`, `reimburse_money`, `voucherid`, `account_user`, `account_time`, `account_note`, `vnote`, `src_type`, `payment_status`, `need_verify`, `src_billtype`, `src_billcode`, `manual_verify_status`, `bratio`, `ts`, `createtime` from yt_piaoeda_piaoeda_client.reimburse_collection);

insert into yt_piaoeda_input_tax.verify_history(`id`, `corpid`, `orgid`, `fp_dm`, `fp_hm`, `result_code`, `result_msg`, `userid`, `username`, `verify_type`, `verify_time`, `createtime`, `ts`) (select `id`, `corpid`, `orgid`, `fp_dm`, `fp_hm`, `result_code`, `result_msg`, `userid`, `username`, `verify_type`, `verify_time`, `createtime`, `ts` from yt_piaoeda_piaoeda_client.verify_history);


/*升级表*/
/* invoice */
alter table invoice add column ZFRQ datetime comment '作废日期';
/* invoice_detail */
alter table invoice_detail modify column xmdj decimal(34,10) DEFAULT NULL COMMENT '项目单价';
alter table invoice_detail add column `YHZCBS` int(1) DEFAULT '0' COMMENT '优惠政策标识';
alter table invoice_detail add column `ZZSTSGL` varchar(50) DEFAULT NULL COMMENT '增值税特殊管理';
/* invoice_ext */
alter table invoice_ext add column `selfcheckstatus` int(11) DEFAULT NULL COMMENT '自检状态';
/* reimburse_collection */
alter table reimburse_collection modify column `src_billtype` varchar(50) DEFAULT NULL COMMENT '来源单据类型';
alter table reimburse_collection add column `manual_verify_period` varchar(6) DEFAULT NULL COMMENT '手工认证期间';
alter table reimburse_collection add column `account_id` int(11) unsigned DEFAULT NULL COMMENT '科目id';
alter table reimburse_collection add column `project_id` int(11) DEFAULT NULL COMMENT '项目id';
alter table reimburse_collection add column `export_rebates` varchar(1) DEFAULT 'N' COMMENT '进口退税';

/*插入新表 */
# Dump of table air_collection
# ------------------------------------------------------------

DROP TABLE IF EXISTS `air_collection`;

CREATE TABLE `air_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `pk_invoice` int(11) NOT NULL COMMENT '发票id',
  `number` varchar(20) NOT NULL COMMENT '行程单号',
  `submitter` varchar(50) DEFAULT NULL COMMENT '提交人（员工账号）',
  `submit_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `reimburse_user` varchar(50) DEFAULT NULL COMMENT '报销人',
  `reimburse_date` timestamp NULL DEFAULT NULL COMMENT '报销日期',
  `reimburse_money` decimal(15,2) DEFAULT NULL COMMENT '报销金额(2位小数)',
  `voucherid` varchar(32) DEFAULT NULL COMMENT '凭证号',
  `account_user` varchar(50) DEFAULT NULL COMMENT '记账人',
  `account_time` datetime DEFAULT NULL COMMENT '记账时间',
  `account_note` varchar(100) DEFAULT NULL COMMENT '记账备注',
  `vnote` varchar(181) DEFAULT NULL COMMENT '备注',
  `src_type` tinyint(4) DEFAULT '1' COMMENT '来源类型 1:手工界面上传；2:外系统接口调用',
  `payment_status` tinyint(4) DEFAULT '1' COMMENT '支付状态;1:未支付，2：已支付',
  `src_billtype` varchar(50) DEFAULT NULL COMMENT '来源单据类型',
  `src_billcode` varchar(30) DEFAULT NULL COMMENT '来源单据号',
  `manual_verify_status` tinyint(4) DEFAULT NULL COMMENT '手工认证状态；1-不需认证；2-未勾选；3-已勾选；4-已认证',
  `period` varchar(6) DEFAULT NULL COMMENT '抵扣期间',
  `bratio` varchar(1) DEFAULT 'N' COMMENT '是否比例转出',
  `account_id` int(11) unsigned DEFAULT NULL COMMENT '科目id',
  `suspect_status` tinyint(4) DEFAULT NULL COMMENT '疑票状态:1.未通过2.已通过3.已禁止',
  `suspect_type` tinyint(4) DEFAULT NULL COMMENT '疑票类型: 1.无电子签章2.证书链不通过3.购买方纳税人识别号为空4.电子签名被篡改5.缺少销货清单6.购买方名称不符7.供应商黑名单8.发票连号9.节假日',
  `suspect_rule` varchar(100) DEFAULT NULL COMMENT '疑票规则',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm` (`number`) USING BTREE,
  KEY `idx_corp_org_invoice` (`orgid`,`pk_invoice`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='航空电子行程单台账';



# Dump of table bd_account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bd_account`;

CREATE TABLE `bd_account` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `tax_body_id` int(10) unsigned NOT NULL COMMENT '纳税主体id',
  `code` varchar(40) NOT NULL COMMENT '科目编码',
  `name` varchar(100) NOT NULL COMMENT '科目名称',
  `balanorient` tinyint(4) NOT NULL COMMENT '0=借方，1=贷方',
  `acctype` tinyint(4) NOT NULL COMMENT '科目类型；0=资产，1=负债，2=权益，3=成本，4=损益类',
  `benable` char(1) NOT NULL DEFAULT 'Y' COMMENT 'N为停用',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_dm_hm` (`name`,`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='会计科目';



# Dump of table bd_user_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bd_user_info`;

CREATE TABLE `bd_user_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(64) NOT NULL COMMENT '用户id',
  `corpid` varchar(64) NOT NULL,
  `orgid` int(11) NOT NULL,
  `header_filepath` varchar(80) DEFAULT NULL,
  `name` varchar(40) NOT NULL COMMENT '个人姓名',
  `sex` char(1) DEFAULT NULL COMMENT '性别；1-男；2-女',
  `mobile` varchar(11) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL COMMENT '国籍',
  `dept` varchar(40) DEFAULT NULL COMMENT '部门',
  `employ_date` date DEFAULT NULL COMMENT '起薪日期',
  `departure_date` date DEFAULT NULL COMMENT '离职日期',
  `corpname` varchar(30) DEFAULT NULL COMMENT '公司名称',
  `employee_id` varchar(40) DEFAULT NULL COMMENT '员工编号',
  `contact` varchar(50) DEFAULT NULL COMMENT '联系地址',
  `identity_type` char(2) NOT NULL DEFAULT '1' COMMENT '证件类型；1.居民身份证、2.军官证、3.士兵证、4.武警警官证、5.港澳居民来往内地通行证、6.台湾居民来往大陆通行证、7.中华人民共和国港澳居民居住证、8.中华人民共和国台湾居民居住证、9.中国护照、10.外国护照、11.香港永久性居民身份证、12.台湾身份证、13.澳门特别行政区永久性居民身份证、14.外国人永久居留身份证',
  `identity_number` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `identity_number_ocr` varchar(18) DEFAULT NULL COMMENT '个人身份证_ocr',
  `identity_number_imp` varchar(18) DEFAULT NULL COMMENT '个人身份证_导入',
  `identity_front` varchar(80) DEFAULT NULL COMMENT '正面附件路径',
  `identity_back` varchar(80) DEFAULT NULL COMMENT '背面附件路径',
  `marital_status` char(1) DEFAULT NULL COMMENT '婚姻状况0未婚,1已婚',
  `spouse_name` varchar(20) DEFAULT NULL COMMENT '配偶姓名',
  `spouse_id_type` char(2) DEFAULT NULL,
  `spouse_id_number` varchar(18) DEFAULT NULL COMMENT '配偶身份证号',
  `spouse_id_front` varchar(80) DEFAULT NULL COMMENT '配偶身份证正面',
  `spouse_id_back` varchar(80) DEFAULT NULL COMMENT '配偶身份证背面',
  `reason` varchar(300) DEFAULT NULL COMMENT '失败原因',
  `approve_status` char(1) DEFAULT NULL COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `cee_approve_status` char(1) DEFAULT NULL,
  `edu_approve_status` char(1) DEFAULT NULL,
  `loan_approve_status` char(1) DEFAULT NULL,
  `rent_approve_status` char(1) DEFAULT NULL,
  `elderly_approve_status` char(1) DEFAULT NULL,
  `martyr_approve_status` char(1) DEFAULT NULL,
  `dis_approve_status` char(1) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL COMMENT '审核时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `disclaimer` char(1) DEFAULT NULL,
  `submittime` datetime DEFAULT NULL,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_orgid` (`orgid`),
  KEY `idx_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个人基本信息';



# Dump of table calendar_holiday
# ------------------------------------------------------------

DROP TABLE IF EXISTS `calendar_holiday`;

CREATE TABLE `calendar_holiday` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `holiday` date DEFAULT NULL COMMENT '节假日 格式:yyyy-MM-dd',
  `corpid` varchar(64) NOT NULL COMMENT '企业id',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_corpid` (`corpid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='节假日日历表';



# Dump of table classify_regex
# ------------------------------------------------------------

DROP TABLE IF EXISTS `classify_regex`;

CREATE TABLE `classify_regex` (
  `id` int(11) NOT NULL COMMENT '主键',
  `classification` varchar(15) DEFAULT NULL COMMENT '发票分类',
  `xmmc_regex` varchar(150) DEFAULT NULL COMMENT '项目名称规则',
  `xsfmc_regex` varchar(150) DEFAULT NULL COMMENT '销售方名称规则',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票自动分类配置信息';



# Dump of table collection_rule
# ------------------------------------------------------------

DROP TABLE IF EXISTS `collection_rule`;

CREATE TABLE `collection_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `collection_type` varchar(10) NOT NULL COMMENT '台账类型:0.报销台账1.采购台账2.不动产台账',
  `bill_type` varchar(10) DEFAULT NULL,
  `rule_name` varchar(100) DEFAULT NULL COMMENT '规则名称',
  `rule_type` varchar(3) DEFAULT NULL COMMENT '规则类型:1.个人通讯费2.发票连号',
  `rule_code` varchar(50) DEFAULT NULL COMMENT '规则编码',
  `priority_level` int(3) DEFAULT NULL COMMENT '规则优先级',
  `validator` varchar(100) DEFAULT NULL COMMENT '规则校验类',
  `corpid` varchar(64) DEFAULT NULL,
  `type` varchar(2) DEFAULT NULL COMMENT '类型0：系统1：自定义',
  `condition_rule` varchar(500) DEFAULT NULL COMMENT '规则条件',
  `process_method` varchar(64) DEFAULT NULL COMMENT '动作 1:不校验2：进入台账 3：拒绝进台账 4：进疑票 5：个人抬头超过6个字符进疑票',
  `version` varchar(2) DEFAULT '1' COMMENT '版本号',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_corpid` (`corpid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='受票台账校验规则表';



# Dump of table customs_book
# ------------------------------------------------------------

DROP TABLE IF EXISTS `customs_book`;

CREATE TABLE `customs_book` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `corpid` varchar(64) NOT NULL,
  `orgid` int(11) unsigned NOT NULL,
  `billing_date` varchar(10) NOT NULL COMMENT '填发日期',
  `customs_name` varchar(30) NOT NULL COMMENT '海关名称',
  `income_system` varchar(20) DEFAULT NULL COMMENT '收入系统',
  `billing_no` varchar(30) DEFAULT NULL COMMENT '海关生清单号码',
  `revenue_org` varchar(20) DEFAULT NULL COMMENT '收入机关',
  `account` varchar(10) DEFAULT NULL COMMENT '收入科目',
  `budgetary_levels` varchar(10) DEFAULT NULL COMMENT '预算级次',
  `revenue_treasury` varchar(20) DEFAULT NULL COMMENT '收款国库',
  `treasury_bank` varchar(20) DEFAULT NULL COMMENT '收入国库银行',
  `payment_org` varchar(40) DEFAULT NULL COMMENT '缴款单位名称',
  `payment_account` varchar(30) DEFAULT NULL COMMENT '缴款账号',
  `payment_bank` varchar(20) DEFAULT NULL COMMENT '缴款单位-银行',
  `total_tax` decimal(15,2) DEFAULT NULL COMMENT '合计税额',
  `apply_org_no` varchar(20) DEFAULT NULL COMMENT '申请单位编号',
  `customs_no` varchar(20) NOT NULL COMMENT '报关单号',
  `contract_no` varchar(20) DEFAULT NULL COMMENT '合同（批文）号',
  `transport_no` varchar(20) DEFAULT NULL COMMENT '运输工具号',
  `cargo_owner` varchar(40) DEFAULT NULL COMMENT '货主单位',
  `operation_entity` varchar(40) DEFAULT NULL COMMENT '经营单位',
  `payment_period` varchar(20) DEFAULT NULL COMMENT '电子支付缴款期限',
  `lading_no` varchar(30) DEFAULT NULL,
  `vnote` varchar(130) DEFAULT NULL COMMENT '备注',
  `billing_maker` varchar(10) DEFAULT NULL COMMENT '制单人',
  `reviewer` varchar(10) DEFAULT NULL COMMENT '复核人',
  `submitter` varchar(50) DEFAULT NULL COMMENT '提交人',
  `submit_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '提交日期',
  `businessman` varchar(50) DEFAULT NULL COMMENT '业务员',
  `status` char(1) DEFAULT '0' COMMENT '状态; 0-未记账；1-已记账',
  `extra_note` varchar(200) DEFAULT NULL COMMENT '额外备注，操作人员的备注非单据备注',
  `check_status` char(1) DEFAULT NULL COMMENT '稽查状态；1-未报送；2-待稽核；3-相符；4-不符；5-滞留；6-缺联；7-重号',
  `check_date` varchar(10) DEFAULT NULL COMMENT '稽查日期',
  `account_user` varchar(50) DEFAULT NULL COMMENT '记账人',
  `account_time` datetime DEFAULT NULL COMMENT '记账日期',
  `account_note` varchar(200) DEFAULT NULL COMMENT '记账备注',
  `voucherid` varchar(32) DEFAULT NULL COMMENT '凭证号',
  `filepath` varchar(200) NOT NULL COMMENT '文件路径',
  `total_price` decimal(20,10) DEFAULT NULL COMMENT '完税价格合计',
  `src_type` tinyint(4) DEFAULT '1' COMMENT '来源类型 1:手工界面上传；2:外系统接口调用',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='海关缴款书台账';



# Dump of table customs_book_b
# ------------------------------------------------------------

DROP TABLE IF EXISTS `customs_book_b`;

CREATE TABLE `customs_book_b` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `hid` int(10) unsigned NOT NULL COMMENT '主表id',
  `tax_no` varchar(20) DEFAULT NULL COMMENT '税号',
  `item_name` varchar(50) NOT NULL COMMENT '货物名称',
  `currency` varchar(10) DEFAULT NULL COMMENT '币种',
  `exchange_rate` decimal(15,8) DEFAULT NULL COMMENT '汇率',
  `price` decimal(20,10) DEFAULT NULL COMMENT '完税价格',
  `tax_rate` decimal(8,6) DEFAULT NULL COMMENT '税率',
  `tax` decimal(15,2) DEFAULT NULL COMMENT '税款金额',
  `unit` varchar(10) DEFAULT NULL COMMENT '单位',
  `count` decimal(15,2) DEFAULT NULL COMMENT '数量',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='海关缴款书明细';



# Dump of table deductible_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `deductible_type`;

CREATE TABLE `deductible_type` (
  `pk_invoice_detail` int(11) NOT NULL,
  `pk_invoice` int(11) NOT NULL,
  `type` tinyint(4) DEFAULT NULL COMMENT '进项分类 1-有形动产租赁；2-运输服务；3-电信服务；4-建筑安装服务；5-不动产租赁服务；6-受让土地使用权；7-金融保险服务；8-生活服务；9-取得无形资产',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_invoice_detail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='进项分类明细';



# Dump of table invoice_air
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_air`;

CREATE TABLE `invoice_air` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` datetime DEFAULT NULL COMMENT '填开日期',
  `ticket_num` char(15) NOT NULL COMMENT '电子客票号码',
  `check_code` varchar(20) DEFAULT NULL COMMENT '验证码',
  `agent_code` varchar(40) DEFAULT NULL COMMENT '销售单位代号',
  `issue_by` varchar(60) DEFAULT NULL COMMENT '填开单位',
  `fare` decimal(15,2) DEFAULT NULL COMMENT '票价',
  `tax` decimal(15,2) DEFAULT NULL COMMENT '其它税费',
  `fuel_surcharge` decimal(15,2) DEFAULT NULL COMMENT '燃油附加费',
  `caac_develop_fund` decimal(15,2) DEFAULT NULL COMMENT '民航发展基金',
  `insurance` decimal(15,2) DEFAULT NULL COMMENT '保险费',
  `total_amount` decimal(15,2) NOT NULL COMMENT '总金额',
  `user_name` varchar(60) DEFAULT NULL COMMENT '乘机人姓名',
  `user_id` char(20) DEFAULT NULL,
  `purchaser_status` tinyint(1) DEFAULT '0' COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `fee_without_tax` decimal(15,2) DEFAULT NULL COMMENT '金额（不含税）',
  `tax_amount` decimal(15,2) DEFAULT NULL COMMENT '税额',
  `file_path` varchar(60) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm` (`ticket_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='航空电子行程单';



# Dump of table invoice_air_b
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_air_b`;

CREATE TABLE `invoice_air_b` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `air_id` bigint(20) NOT NULL COMMENT '航空行程单主表主键',
  `from` varchar(60) DEFAULT NULL COMMENT '出发',
  `to` varchar(60) DEFAULT NULL COMMENT '到达',
  `flight_number` varchar(40) DEFAULT NULL COMMENT '航班号',
  `carrier` varchar(20) DEFAULT NULL COMMENT '承运人',
  `seat` varchar(40) DEFAULT NULL COMMENT '舱位',
  `date` datetime DEFAULT NULL COMMENT '乘机日期',
  `time` varchar(20) DEFAULT NULL COMMENT '乘机时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='航空电子行程单明细';



# Dump of table invoice_build
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_build`;

CREATE TABLE `invoice_build` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` varchar(64) NOT NULL COMMENT '组织id',
  `pk_invoice` int(11) NOT NULL COMMENT '发票id',
  `fp_dm` varchar(12) NOT NULL COMMENT '发票代码',
  `fp_hm` varchar(8) NOT NULL COMMENT '发票号码',
  `collection_type` int(1) NOT NULL COMMENT '台账类型 0：报销，1：采购，2：不动产',
  `collection_id` int(11) NOT NULL COMMENT '台账id',
  `project_id` int(11) NOT NULL COMMENT '项目id',
  `sub_project_id` int(11) DEFAULT NULL COMMENT '分包管理id',
  `prepayment_id` int(11) DEFAULT NULL COMMENT '预缴管理id',
  `bsubinvoice` char(1) DEFAULT NULL COMMENT '是否分包发票 N：否 Y：是',
  `prepay_deduction` char(1) DEFAULT NULL COMMENT '预缴扣除状态  0：未扣除；1：待扣除；2：已扣除',
  `prepay_period` varchar(7) DEFAULT NULL COMMENT '预交所属期',
  `declare_period` varchar(7) DEFAULT NULL COMMENT '申报所属期',
  `declare_status` int(1) DEFAULT NULL COMMENT '申报状态 1：未申报 2：已申报',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_building_dm_hm` (`fp_dm`,`fp_hm`),
  KEY `idx_building_org_invoice` (`orgid`,`pk_invoice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票台账建筑属性';



# Dump of table invoice_collection
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_collection`;

CREATE TABLE `invoice_collection` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpId` varchar(64) DEFAULT NULL COMMENT '公司id',
  `orgId` int(10) unsigned DEFAULT NULL COMMENT '组织id',
  `pk_invoice` int(11) NOT NULL COMMENT '发票索引号',
  `fp_dm` varchar(12) DEFAULT NULL COMMENT '发票代码',
  `fp_hm` varchar(8) DEFAULT NULL COMMENT '发票号码',
  `submitter` varchar(50) DEFAULT NULL COMMENT '提交人（员工账号）',
  `submit_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `purchaser` varchar(50) DEFAULT NULL COMMENT '采购员',
  `vnote` varchar(200) DEFAULT NULL COMMENT '备注',
  `src_type` tinyint(4) DEFAULT '1' COMMENT '来源类型 1:手工界面上传；2:外系统接口调用',
  `need_verify` char(1) DEFAULT NULL COMMENT '是否需要认证；N-不需要认证，Y-需要认证；专票使用',
  `voucherid` varchar(32) DEFAULT NULL COMMENT '凭证号',
  `account_user` varchar(50) DEFAULT NULL COMMENT '记账人',
  `account_time` datetime DEFAULT NULL COMMENT '记账日期',
  `account_note` varchar(100) DEFAULT NULL COMMENT '记账备注',
  `src_billtype` varchar(50) DEFAULT NULL COMMENT '来源单据类型',
  `src_billcode` varchar(30) DEFAULT NULL COMMENT '来源单据号',
  `manual_verify_status` tinyint(4) DEFAULT NULL COMMENT '手工认证状态；1-不需认证；2-未勾选；3-已勾选；4-已认证',
  `bratio` varchar(1) DEFAULT 'N' COMMENT '是否比例转出',
  `account_id` int(11) unsigned DEFAULT NULL COMMENT '科目id',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `export_rebates` varchar(1) DEFAULT 'N' COMMENT '进口退税',
  PRIMARY KEY (`ID`),
  KEY `idx_invcollection_dmhm` (`fp_hm`,`fp_dm`),
  KEY `idx_corp_org_invoice` (`orgId`,`pk_invoice`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购台账';



# Dump of table invoice_deduct_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_deduct_log`;

CREATE TABLE `invoice_deduct_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `nsrsbh` varchar(20) NOT NULL COMMENT '纳税人识别号',
  `start_time` datetime DEFAULT NULL COMMENT '任务开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '任务结束时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务执行状态；1=成功；2=失败',
  `detail` varchar(200) DEFAULT NULL COMMENT '明细信息',
  `period` varchar(6) DEFAULT NULL COMMENT '认证数据期间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_nsrsbh_deduct` (`nsrsbh`,`corpid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='进项抓取日志';



# Dump of table invoice_deductible
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_deductible`;

CREATE TABLE `invoice_deductible` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) DEFAULT NULL COMMENT '组织id',
  `fp_dm` varchar(12) NOT NULL COMMENT '发票代码',
  `fp_hm` varchar(8) NOT NULL COMMENT '发票号码',
  `kprq` date DEFAULT NULL COMMENT '开票日期',
  `xsf_mc` varchar(100) DEFAULT NULL COMMENT '销售方名称',
  `xsf_nsrsbh` varchar(20) DEFAULT NULL COMMENT '销售方纳税人识别号',
  `gmf_nsrsbh` varchar(20) DEFAULT NULL COMMENT '购买方纳税人识别号',
  `hjje` decimal(15,2) NOT NULL COMMENT '合计金额',
  `hjse` decimal(15,2) NOT NULL COMMENT '合计税额',
  `verify_status` tinyint(4) DEFAULT NULL COMMENT '认证状态；1-不需认证；2-未勾选；3-已勾选；4-已认证',
  `select_person` varchar(64) DEFAULT NULL COMMENT '勾选人',
  `select_time` date DEFAULT NULL COMMENT '勾选时间',
  `verify_type` tinyint(4) DEFAULT NULL COMMENT '认证类别 1-勾选认证；2-扫码认证',
  `verify_person` varchar(64) DEFAULT NULL COMMENT '认证人',
  `verify_time` date DEFAULT NULL COMMENT '认证时间',
  `fplx` varchar(4) DEFAULT NULL COMMENT '发票类型；2-增值税电子专用发票；5-机动车销售统一发票',
  `fpzt` tinyint(4) DEFAULT '0' COMMENT '进项发票状态；0-正常，1-失控，2-作废，3-红冲，4-异常',
  `period` varchar(6) DEFAULT NULL COMMENT '认证期间',
  `precheck_status` tinyint(1) DEFAULT '0' COMMENT '预勾选状态： 1. 已勾选 0.未勾选',
  `precheck_person` varchar(64) NOT NULL DEFAULT '' COMMENT '预勾选用户ID',
  `precheck_time` datetime DEFAULT NULL COMMENT '预勾选时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usage` varchar(1) DEFAULT '1' COMMENT '发票用途 1.抵扣 2.不抵扣',
  `yxse` decimal(15,2) DEFAULT '0.00' COMMENT '有效税额',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_deductible_hm` (`fp_dm`,`fp_hm`) USING BTREE,
  KEY `idx_deductible_kprq` (`kprq`),
  KEY `idx_deductible_crp` (`gmf_nsrsbh`,`corpid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='勾选认证明细';



# Dump of table invoice_deductible_bak
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_deductible_bak`;

CREATE TABLE `invoice_deductible_bak` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) DEFAULT NULL COMMENT '公司id',
  `orgid` int(11) DEFAULT NULL COMMENT '组织id',
  `fp_dm` varchar(12) NOT NULL COMMENT '发票代码',
  `fp_hm` varchar(8) NOT NULL COMMENT '发票号码',
  `kprq` date DEFAULT NULL COMMENT '开票日期',
  `xsf_mc` varchar(100) DEFAULT NULL COMMENT '销售方名称',
  `xsf_nsrsbh` varchar(20) DEFAULT NULL COMMENT '销售方纳税人识别号',
  `gmf_nsrsbh` varchar(20) DEFAULT NULL COMMENT '购买方纳税人识别号',
  `hjje` decimal(15,2) NOT NULL COMMENT '合计金额',
  `hjse` decimal(15,2) NOT NULL COMMENT '合计税额',
  `verify_status` tinyint(4) DEFAULT NULL COMMENT '认证状态；1-不需认证；2-未勾选；3-已勾选；4-已认证',
  `select_person` varchar(64) DEFAULT NULL COMMENT '勾选人',
  `select_time` date DEFAULT NULL COMMENT '勾选时间',
  `verify_type` tinyint(4) DEFAULT NULL COMMENT '认证类别 1-勾选认证；2-扫码认证',
  `verify_person` varchar(64) DEFAULT NULL COMMENT '认证人',
  `verify_time` date DEFAULT NULL COMMENT '认证时间',
  `fplx` char(2) DEFAULT NULL COMMENT '发票类型；2-增值税电子专用发票；5-机动车销售统一发票',
  `fpzt` tinyint(4) DEFAULT '0' COMMENT '进项发票状态；0-正常，1-失控，2-作废，3-红冲，4-异常',
  `period` varchar(6) DEFAULT NULL COMMENT '认证期间',
  `dm_hm` varchar(20) NOT NULL COMMENT '代码、号码',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_deductible_hm` (`dm_hm`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='勾选认证明细备份';



# Dump of table invoice_detail_motor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_detail_motor`;

CREATE TABLE `invoice_detail_motor` (
  `pk_invoice_detail` int(10) unsigned NOT NULL COMMENT '子表主键',
  `pk_invoice` int(10) unsigned NOT NULL COMMENT '发票PK',
  `cd` varchar(80) DEFAULT NULL COMMENT '产地',
  `hgzh` varchar(100) DEFAULT NULL COMMENT '合格证号',
  `jkzmsh` varchar(80) DEFAULT NULL COMMENT '进口证明书号',
  `sjdh` varchar(80) DEFAULT NULL COMMENT '商检单号',
  `fdjhm` varchar(120) DEFAULT NULL COMMENT '发动机号码',
  `cjhm` varchar(40) DEFAULT NULL COMMENT '车架号码',
  `dunwei` varchar(40) DEFAULT NULL COMMENT '吨位',
  `xcrs` varchar(40) DEFAULT NULL COMMENT '限乘人数',
  `cllx` varchar(40) DEFAULT NULL COMMENT '车辆类型',
  `cpxh` varchar(60) DEFAULT NULL COMMENT '厂牌型号',
  `scqymc` varchar(240) DEFAULT NULL COMMENT '生产企业名称',
  `sfzhm` varchar(22) DEFAULT NULL COMMENT '身份证号码/组织机构代码',
  `dz` varchar(80) DEFAULT NULL COMMENT '地址',
  `dh` varchar(40) DEFAULT NULL COMMENT '电话',
  `khyh` varchar(80) DEFAULT NULL COMMENT '开户银行',
  `zh` varchar(40) DEFAULT NULL COMMENT '账户',
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`pk_invoice_detail`),
  KEY `idx_motor_inv` (`pk_invoice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机动车明细扩展表';



# Dump of table invoice_machine
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_machine`;

CREATE TABLE `invoice_machine` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` datetime DEFAULT NULL COMMENT '开票日期',
  `time` varchar(20) DEFAULT NULL COMMENT '开票时间',
  `invoice_code` varchar(12) NOT NULL COMMENT '发票代码',
  `invoice_num` varchar(8) NOT NULL COMMENT '发票号码',
  `check_code` varchar(20) DEFAULT NULL COMMENT '校验码',
  `category` varchar(20) DEFAULT NULL COMMENT '种类，oil 表示是加油票',
  `total_amount` decimal(15,2) NOT NULL COMMENT '合计金额',
  `seller_name` varchar(40) DEFAULT NULL COMMENT '销售方名称',
  `seller_tax_id` char(20) DEFAULT NULL COMMENT '销售方纳税人识别号',
  `buyer_name` varchar(40) DEFAULT NULL COMMENT '购买方名称',
  `buyer_tax_id` char(20) DEFAULT NULL COMMENT '购买方纳税人识别号',
  `purchaser_status` tinyint(1) DEFAULT NULL COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `file_path` varchar(60) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`invoice_num`,`invoice_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机打发票';



# Dump of table invoice_machine_b
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_machine_b`;

CREATE TABLE `invoice_machine_b` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `machine_id` bigint(20) DEFAULT NULL COMMENT '机打发票主表主键',
  `item` varchar(20) DEFAULT NULL COMMENT '项目',
  `amount` decimal(15,2) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机打发票明细';



# Dump of table invoice_other
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_other`;

CREATE TABLE `invoice_other` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `invoice_code` varchar(32) DEFAULT NULL COMMENT '发票代码',
  `invoice_num` varchar(32) NOT NULL COMMENT '发票号码',
  `date` timestamp NULL DEFAULT NULL COMMENT '日期',
  `total_amount` decimal(15,2) DEFAULT '0.00' COMMENT '票面金额',
  `purchaser_status` tinyint(1) DEFAULT '-1' COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `file_path` varchar(60) DEFAULT NULL COMMENT '发票文件地址',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_hm` (`invoice_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='其他票种';



# Dump of table invoice_passenger
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_passenger`;

CREATE TABLE `invoice_passenger` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invoice_code` varchar(12) DEFAULT NULL COMMENT '发票代码',
  `invoice_num` varchar(16) DEFAULT NULL COMMENT '发票号码',
  `date` datetime DEFAULT NULL COMMENT '日期',
  `time` varchar(20) DEFAULT NULL COMMENT '时间',
  `entrance` varchar(60) DEFAULT NULL COMMENT '入口',
  `exit` varchar(60) DEFAULT NULL COMMENT '出口',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `total_amount` decimal(15,2) NOT NULL COMMENT '金额',
  `purchaser_status` tinyint(1) DEFAULT NULL COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `fee_without_tax` decimal(15,2) DEFAULT NULL COMMENT '合计金额（不含税）',
  `tax_amount` decimal(15,2) DEFAULT NULL COMMENT '税额',
  `file_path` varchar(60) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`invoice_num`,`invoice_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客运汽车票';



# Dump of table invoice_quota
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_quota`;

CREATE TABLE `invoice_quota` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invoice_code` varchar(12) NOT NULL COMMENT '发票代码',
  `invoice_num` varchar(8) NOT NULL COMMENT '发票号码',
  `total_amount` decimal(15,2) NOT NULL COMMENT '金额',
  `purchaser_status` tinyint(1) DEFAULT NULL COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `file_path` varchar(60) DEFAULT NULL,
  `product_name` varchar(20) DEFAULT NULL COMMENT '商品项目',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`invoice_num`,`invoice_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定额发票';



# Dump of table invoice_taxi
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_taxi`;

CREATE TABLE `invoice_taxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` datetime DEFAULT NULL COMMENT '开票日期',
  `invoice_code` varchar(12) DEFAULT NULL COMMENT '发票代码',
  `invoice_num` varchar(8) DEFAULT NULL COMMENT '发票号码',
  `car_num` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `mileage` decimal(15,2) DEFAULT NULL COMMENT '里程',
  `start_time` varchar(20) DEFAULT NULL COMMENT '上车时间',
  `end_time` varchar(20) DEFAULT NULL COMMENT '下车时间',
  `total_amount` decimal(15,2) NOT NULL COMMENT '金额',
  `purchaser_status` tinyint(1) DEFAULT NULL COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `place` varchar(20) DEFAULT NULL COMMENT '发票所在地',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `file_path` varchar(60) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`invoice_num`,`invoice_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出租车票';



# Dump of table invoice_tolls
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_tolls`;

CREATE TABLE `invoice_tolls` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invoice_code` varchar(12) NOT NULL COMMENT '发票代码',
  `invoice_num` varchar(20) NOT NULL COMMENT '发票号码',
  `date` datetime DEFAULT NULL COMMENT '日期',
  `time` varchar(20) DEFAULT NULL COMMENT '时间',
  `entrance` varchar(30) DEFAULT NULL COMMENT '入口',
  `exit` varchar(30) DEFAULT NULL COMMENT '出口',
  `total_amount` decimal(15,2) NOT NULL COMMENT '金额',
  `purchaser_status` tinyint(1) DEFAULT NULL COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `file_path` varchar(60) DEFAULT NULL COMMENT '文件路径',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`invoice_num`,`invoice_code`) USING BTREE COMMENT '发票代码、号码唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='过路费';



# Dump of table invoice_train
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_train`;

CREATE TABLE `invoice_train` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `number` varchar(32) DEFAULT NULL COMMENT '号码（火车票唯一性）',
  `ticket_num` varchar(12) DEFAULT NULL COMMENT '火车票号',
  `date` datetime NOT NULL COMMENT '日期',
  `time` varchar(20) DEFAULT NULL COMMENT '时间',
  `train_num` varchar(10) DEFAULT NULL COMMENT '车次',
  `origin` varchar(20) DEFAULT NULL COMMENT '始发站',
  `destination` varchar(20) DEFAULT NULL COMMENT '终点站',
  `level` varchar(10) DEFAULT NULL COMMENT '坐席',
  `seat_no` varchar(20) DEFAULT NULL COMMENT '座位号',
  `name` varchar(20) DEFAULT '' COMMENT '姓名',
  `total_amount` decimal(15,2) NOT NULL COMMENT '金额',
  `fee_without_tax` decimal(15,2) DEFAULT NULL COMMENT '金额（不含税）',
  `tax_amount` decimal(15,2) DEFAULT NULL COMMENT '税额',
  `purchaser_status` tinyint(1) DEFAULT NULL COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `file_path` varchar(60) DEFAULT NULL COMMENT '文件路径',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='火车票';



# Dump of table machine_collection
# ------------------------------------------------------------

DROP TABLE IF EXISTS `machine_collection`;

CREATE TABLE `machine_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `pk_invoice` int(11) NOT NULL COMMENT '发票id',
  `fp_dm` varchar(12) DEFAULT NULL COMMENT '代码',
  `fp_hm` varchar(8) DEFAULT NULL COMMENT '号码',
  `submitter` varchar(50) DEFAULT NULL COMMENT '提交人（员工账号）',
  `submit_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `reimburse_user` varchar(50) DEFAULT NULL COMMENT '报销人',
  `reimburse_date` timestamp NULL DEFAULT NULL COMMENT '报销日期',
  `reimburse_money` decimal(15,2) DEFAULT NULL COMMENT '报销金额(2位小数)',
  `voucherid` varchar(32) DEFAULT NULL COMMENT '凭证号',
  `account_user` varchar(50) DEFAULT NULL COMMENT '记账人',
  `account_time` datetime DEFAULT NULL COMMENT '记账时间',
  `account_note` varchar(100) DEFAULT NULL COMMENT '记账备注',
  `vnote` varchar(181) DEFAULT NULL COMMENT '备注',
  `src_type` tinyint(4) DEFAULT '1' COMMENT '来源类型 1:手工界面上传；2:外系统接口调用',
  `payment_status` tinyint(4) DEFAULT '1' COMMENT '支付状态;1:未支付，2：已支付',
  `src_billtype` varchar(50) DEFAULT NULL COMMENT '来源单据类型',
  `src_billcode` varchar(30) DEFAULT NULL COMMENT '来源单据号',
  `manual_verify_status` tinyint(4) DEFAULT NULL COMMENT '手工认证状态；1-不需认证；2-未勾选；3-已勾选；4-已认证',
  `bratio` varchar(1) DEFAULT 'N' COMMENT '是否比例转出',
  `account_id` int(11) unsigned DEFAULT NULL COMMENT '科目id',
  `suspect_status` tinyint(4) DEFAULT NULL COMMENT '疑票状态:1.未通过2.已通过3.已禁止',
  `suspect_type` tinyint(4) DEFAULT NULL COMMENT '疑票类型: 1.无电子签章2.证书链不通过3.购买方纳税人识别号为空4.电子签名被篡改5.缺少销货清单6.购买方名称不符7.供应商黑名单8.发票连号9.节假日',
  `suspect_rule` varchar(100) DEFAULT NULL COMMENT '疑票规则',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`fp_hm`,`fp_dm`) USING BTREE,
  KEY `idx_corp_org_invoice` (`orgid`,`pk_invoice`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='机打发票台账';



# Dump of table ocr_airport
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ocr_airport`;

CREATE TABLE `ocr_airport` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `airport_code` char(3) NOT NULL DEFAULT '' COMMENT '机场三字码',
  `airport_name` varchar(16) NOT NULL DEFAULT '' COMMENT '机场名称',
  `city_code` char(3) NOT NULL DEFAULT '' COMMENT '城市代码',
  `city_name` varchar(16) NOT NULL DEFAULT '' COMMENT '城市名称',
  `province` varchar(16) NOT NULL DEFAULT '' COMMENT '省名称',
  `keyword` varchar(50) NOT NULL DEFAULT '' COMMENT '关键字',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ocr机场表';



# Dump of table ocr_file_rel
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ocr_file_rel`;

CREATE TABLE `ocr_file_rel` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `file_path` varchar(60) NOT NULL COMMENT '文件路径',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ocr文件路径（私有部署使用，公有云不用）';



# Dump of table ocr_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ocr_log`;

CREATE TABLE `ocr_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corp_id` varchar(64) NOT NULL COMMENT '公司ID',
  `orgid` int(10) unsigned DEFAULT NULL COMMENT '组织id',
  `user_code` varchar(64) DEFAULT NULL COMMENT '用户编码',
  `src_type` varchar(5) NOT NULL DEFAULT 'WEB' COMMENT '来源类型 WEB-网页 APP-票友记',
  `provider` varchar(20) NOT NULL DEFAULT 'TC' COMMENT 'OCR供应商 TC-天创',
  `rtn_code` varchar(8) DEFAULT NULL COMMENT '识别返回状态码',
  `rtn_msg` varchar(100) DEFAULT NULL COMMENT '识别返回结果',
  `fp_dm` varchar(16) DEFAULT NULL COMMENT '发票代码',
  `fp_hm` varchar(16) DEFAULT NULL COMMENT '发票号码',
  `kprq` varchar(14) DEFAULT NULL COMMENT '开票日期',
  `hjje` decimal(15,2) DEFAULT NULL COMMENT '合计金额',
  `jym` varchar(24) DEFAULT NULL COMMENT '校验码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `ocr_id` varchar(60) DEFAULT NULL COMMENT 'ocrid',
  `file_path` varchar(60) DEFAULT NULL COMMENT '文件路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='OCR日志表';



# Dump of table ocr_specify
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ocr_specify`;

CREATE TABLE `ocr_specify` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `corpid` varchar(64) NOT NULL DEFAULT '' COMMENT '公司ID,默认服务为default',
  `service_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户指定的服务对应的service',
  `enable_flag` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可用 0：不可用 1：可用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ocr指定服务提供商';



# Dump of table other_collection
# ------------------------------------------------------------

DROP TABLE IF EXISTS `other_collection`;

CREATE TABLE `other_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `pk_invoice` int(11) NOT NULL COMMENT '发票id',
  `fp_dm` varchar(32) DEFAULT '' COMMENT '代码',
  `fp_hm` varchar(32) NOT NULL COMMENT '号码',
  `submitter` varchar(50) DEFAULT NULL COMMENT '提交人（员工账号）',
  `submit_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `reimburse_user` varchar(50) DEFAULT NULL COMMENT '报销人',
  `reimburse_date` timestamp NULL DEFAULT NULL COMMENT '报销日期',
  `reimburse_money` decimal(15,2) DEFAULT NULL COMMENT '报销金额(2位小数)',
  `voucherid` varchar(32) DEFAULT NULL COMMENT '凭证号',
  `account_user` varchar(50) DEFAULT NULL COMMENT '记账人',
  `account_time` datetime DEFAULT NULL COMMENT '记账时间',
  `account_note` varchar(100) DEFAULT NULL COMMENT '记账备注',
  `vnote` varchar(181) DEFAULT NULL COMMENT '备注',
  `src_type` tinyint(4) DEFAULT '1' COMMENT '来源类型 1:手工界面上传；2:外系统接口调用',
  `payment_status` tinyint(4) DEFAULT '1' COMMENT '支付状态;1:未支付，2：已支付',
  `src_billtype` varchar(50) DEFAULT NULL COMMENT '来源单据类型',
  `src_billcode` varchar(30) DEFAULT NULL COMMENT '来源单据号',
  `manual_verify_status` tinyint(4) DEFAULT NULL COMMENT '手工认证状态；1-不需认证；2-未勾选；3-已勾选；4-已认证',
  `bratio` varchar(1) DEFAULT 'N' COMMENT '是否比例转出',
  `suspect_status` tinyint(4) DEFAULT NULL COMMENT '疑票状态:1.未通过2.已通过3.已禁止',
  `suspect_type` tinyint(4) DEFAULT NULL COMMENT '疑票类型: 1.无电子签章2.证书链不通过3.购买方纳税人识别号为空4.电子签名被篡改5.缺少销货清单6.购买方名称不符7.供应商黑名单8.发票连号9.节假日',
  `suspect_rule` varchar(100) DEFAULT NULL COMMENT '疑票规则',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`fp_hm`,`fp_dm`) USING BTREE,
  KEY `idx_corp_org_invoice` (`orgid`,`pk_invoice`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='其他票种台账';



# Dump of table out_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `out_detail`;

CREATE TABLE `out_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fpdm` varchar(12) DEFAULT NULL COMMENT '发票代码',
  `fphm` varchar(8) DEFAULT NULL COMMENT '发票号码',
  `out_money` decimal(15,2) NOT NULL COMMENT '转出税额',
  `reason` tinyint(4) NOT NULL COMMENT '转出原因 1-免税项目用；2-集体福利、个人消费；3-非正常损失；4-简易计税方法征税项目用；5-红字专用发票信息表注明的进项税额；6-其他应作进项税额转出的情形',
  `out_datetime` datetime DEFAULT NULL COMMENT '转出时间',
  `operator` varchar(64) DEFAULT NULL,
  `vnote` varchar(181) DEFAULT NULL COMMENT '备注',
  `out_gather_id` int(11) unsigned DEFAULT NULL,
  `src_type` char(1) DEFAULT '1' COMMENT '转出来源类型；1：平台2：接口',
  `data_src` char(1) DEFAULT NULL COMMENT '数据来源类型;1-报销台账;2-采购台账;3-不动产及在建工程台账;4-手工转出',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `voucherid` varchar(50) NOT NULL DEFAULT '' COMMENT '转出凭证号',
  `corpid` varchar(64) DEFAULT NULL COMMENT '公司id',
  `orgid` varchar(36) DEFAULT NULL COMMENT '组织id',
  PRIMARY KEY (`id`),
  KEY `idx_out_hm_dm` (`fphm`,`fpdm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='转出明细';



# Dump of table out_gather
# ------------------------------------------------------------

DROP TABLE IF EXISTS `out_gather`;

CREATE TABLE `out_gather` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `nsrsbh` varchar(20) NOT NULL COMMENT '纳税人识别号',
  `out_money` decimal(15,2) DEFAULT NULL COMMENT '按比例转出汇总金额',
  `period_begin` varchar(7) DEFAULT NULL COMMENT '期间开始',
  `period_end` varchar(7) DEFAULT NULL COMMENT '期间结束',
  `reason` tinyint(4) DEFAULT NULL COMMENT '转出原因 1-免税项目用；2-集体福利、个人消费；3-非正常损失；4-简易计税方法征税项目用；5-红字专用发票信息表注明的进项税额；6-其他应作进项税额转出的情形；7-免抵退税办法不得抵扣的进项税额；8-纳税检查调减进项税额；9-上期留抵税额抵减欠税；10-上期留抵税额退税',
  `out_datetime` datetime DEFAULT NULL,
  `operator` varchar(64) DEFAULT NULL,
  `ratio` decimal(7,6) DEFAULT NULL,
  `vnote` varchar(181) DEFAULT NULL,
  `data_src` char(1) DEFAULT NULL COMMENT '来源类型；1-报销台账；2-采购台账',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='按销售比例转出汇总表';



# Dump of table passenger_collection
# ------------------------------------------------------------

DROP TABLE IF EXISTS `passenger_collection`;

CREATE TABLE `passenger_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `pk_invoice` int(11) NOT NULL COMMENT '发票id',
  `fp_dm` varchar(12) DEFAULT NULL COMMENT '代码',
  `fp_hm` varchar(16) DEFAULT NULL COMMENT '号码',
  `submitter` varchar(50) DEFAULT NULL COMMENT '提交人（员工账号）',
  `submit_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `reimburse_user` varchar(50) DEFAULT NULL COMMENT '报销人',
  `reimburse_date` timestamp NULL DEFAULT NULL COMMENT '报销日期',
  `reimburse_money` decimal(15,2) DEFAULT NULL COMMENT '报销金额(2位小数)',
  `voucherid` varchar(32) DEFAULT NULL COMMENT '凭证号',
  `account_user` varchar(50) DEFAULT NULL COMMENT '记账人',
  `account_time` datetime DEFAULT NULL COMMENT '记账时间',
  `account_note` varchar(100) DEFAULT NULL COMMENT '记账备注',
  `vnote` varchar(181) DEFAULT NULL COMMENT '备注',
  `src_type` tinyint(4) DEFAULT '1' COMMENT '来源类型 1:手工界面上传；2:外系统接口调用',
  `payment_status` tinyint(4) DEFAULT '1' COMMENT '支付状态;1:未支付，2：已支付',
  `src_billtype` varchar(50) DEFAULT NULL COMMENT '来源单据类型',
  `src_billcode` varchar(30) DEFAULT NULL COMMENT '来源单据号',
  `manual_verify_status` tinyint(4) DEFAULT NULL COMMENT '手工认证状态；1-不需认证；2-未勾选；3-已勾选；4-已认证',
  `period` varchar(6) DEFAULT NULL COMMENT '抵扣期间',
  `bratio` varchar(1) DEFAULT 'N' COMMENT '是否比例转出',
  `account_id` int(11) unsigned DEFAULT NULL COMMENT '科目id',
  `suspect_status` tinyint(4) DEFAULT NULL COMMENT '疑票状态:1.未通过2.已通过3.已禁止',
  `suspect_type` tinyint(4) DEFAULT NULL COMMENT '疑票类型: 1.无电子签章2.证书链不通过3.购买方纳税人识别号为空4.电子签名被篡改5.缺少销货清单6.购买方名称不符7.供应商黑名单8.发票连号9.节假日',
  `suspect_rule` varchar(100) DEFAULT NULL COMMENT '疑票规则',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`fp_hm`,`fp_dm`) USING BTREE,
  KEY `idx_corp_org_invoice` (`orgid`,`pk_invoice`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='客运汽车发票台账';



# Dump of table pdf_parse_record
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pdf_parse_record`;

CREATE TABLE `pdf_parse_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fpdm` char(12) DEFAULT NULL COMMENT '发票代码',
  `fphm` char(8) DEFAULT NULL COMMENT '发票号码',
  `jym` char(20) DEFAULT NULL COMMENT '校验码',
  `hjje` decimal(15,2) DEFAULT NULL COMMENT '合计金额',
  `kprq` datetime DEFAULT NULL COMMENT '开票日期',
  `state` char(1) DEFAULT NULL COMMENT '1:成功。0：失败',
  `msg` varchar(255) DEFAULT NULL COMMENT '详情',
  `corpid` varchar(64) DEFAULT NULL COMMENT '租户id',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  KEY `corpid_idx` (`corpid`) USING BTREE COMMENT '租户索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='pdf解析调用记录';



# Dump of table pit_cee
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_cee`;

CREATE TABLE `pit_cee` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL COMMENT '父id',
  `userid` varchar(64) DEFAULT NULL,
  `edu_stage` char(1) DEFAULT NULL COMMENT '学历教育姓名',
  `edu_start` date DEFAULT NULL COMMENT '学习起始日期',
  `edu_end` date DEFAULT NULL COMMENT '预计结束日期',
  `student_filepath` varchar(80) DEFAULT NULL COMMENT '学籍证明',
  `edu_type` char(1) DEFAULT NULL COMMENT '教育类型，1-成人高等教育；2-高等教育自学考试；3-电大现代远程开放教育和网络大学',
  `vocational_date` date DEFAULT NULL COMMENT '职业资格-发证日期',
  `vocational_cert_name` varchar(30) DEFAULT NULL COMMENT '职业资格-证书名称',
  `vocational_number` varchar(40) DEFAULT NULL COMMENT '职业资格-证书编号',
  `vocational_org` varchar(30) DEFAULT NULL COMMENT '职业资格-发证机构',
  `vocational_filepath` varchar(80) DEFAULT NULL COMMENT '职业资格证书附件',
  `approve_status` char(1) DEFAULT '1' COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL COMMENT '审核通过时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_hid` (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='继续教育专项附加扣除';



# Dump of table pit_children_edu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_children_edu`;

CREATE TABLE `pit_children_edu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL COMMENT '父id',
  `userid` varchar(64) DEFAULT NULL,
  `name` varchar(20) NOT NULL COMMENT '子女姓名',
  `identity_type` char(2) DEFAULT NULL COMMENT '证件类型',
  `identity_number` varchar(18) DEFAULT NULL COMMENT '证件',
  `birthday` date NOT NULL COMMENT '出生日期',
  `current_edu` char(2) DEFAULT '0' COMMENT '教育阶段，0-无；1-学前教育；2-小学；3-初中教育；4-普通高中；5-中等职业教育；6-大学专科；7-大学本科；8-硕士研究生；9-博士研究生教育',
  `school` varchar(100) DEFAULT NULL COMMENT '就读学校',
  `country` varchar(30) DEFAULT NULL COMMENT '就读国家',
  `student_number` varchar(20) DEFAULT NULL COMMENT '学籍号',
  `deduction_method` char(1) DEFAULT '1' COMMENT '扣除方式，1-由本人扣除；2-由配偶扣除；3-按50%分别扣除',
  `edu_start` date DEFAULT NULL COMMENT '学习起始日期',
  `edu_end` date DEFAULT NULL COMMENT '学习结束日期',
  `edu_Final` date DEFAULT NULL COMMENT '教育终止日期',
  `household_master` varchar(80) DEFAULT NULL COMMENT '户口主页',
  `household_sub` varchar(80) DEFAULT NULL COMMENT '户口附页',
  `student_certificate` varchar(80) DEFAULT NULL COMMENT '学籍证明附件',
  `nationality` varchar(30) DEFAULT NULL COMMENT '国籍',
  `approve_status` char(1) DEFAULT '1' COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL COMMENT '审核时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_hid` (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='子女教育专项附加扣除';



# Dump of table pit_declaration
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_declaration`;

CREATE TABLE `pit_declaration` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `corpid` varchar(64) NOT NULL,
  `orgid` int(11) NOT NULL,
  `orgname` varchar(64) NOT NULL,
  `nsrsbh` varchar(20) NOT NULL,
  `declare_period` varchar(20) DEFAULT NULL COMMENT '申报期',
  `declare_date_start` datetime DEFAULT NULL COMMENT '上期申报日期',
  `declare_date_end` datetime DEFAULT NULL COMMENT '本期申报日期',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='月结日志';



# Dump of table pit_deduction
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_deduction`;

CREATE TABLE `pit_deduction` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `corpid` varchar(64) DEFAULT NULL,
  `orgid` int(11) DEFAULT NULL,
  `userid` varchar(64) NOT NULL,
  `total_cee` decimal(15,2) DEFAULT NULL COMMENT '累计学历学位继续教育',
  `total_vocation_cee` decimal(15,2) DEFAULT NULL COMMENT '累计职业资格继续教育',
  `total_child_edu` decimal(15,2) DEFAULT NULL COMMENT '累计子女教育',
  `total_housing_loan` decimal(15,2) DEFAULT NULL COMMENT '累计住房贷款',
  `total_housing_rent` decimal(15,2) DEFAULT NULL COMMENT '累计住房租金',
  `total_elderly` decimal(15,2) DEFAULT NULL COMMENT '累计赡养老人',
  `is_disability` char(1) DEFAULT NULL,
  `is_martyr` char(1) DEFAULT NULL,
  `declare_period` varchar(20) DEFAULT NULL COMMENT '申报期',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='月结扣除信息';



# Dump of table pit_disability
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_disability`;

CREATE TABLE `pit_disability` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL COMMENT '父id',
  `userid` varchar(64) DEFAULT NULL,
  `disability_type` char(1) DEFAULT NULL COMMENT '残疾类型',
  `disability_card_no` varchar(20) DEFAULT NULL COMMENT '残疾人证号',
  `disability_card_date` date DEFAULT NULL COMMENT '残疾证发起日期',
  `disability_filepath` varchar(80) DEFAULT NULL COMMENT '残疾人证件附件',
  `approve_status` char(1) DEFAULT '1' COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_hid` (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='残疾人相关\r\n';



# Dump of table pit_elderly
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_elderly`;

CREATE TABLE `pit_elderly` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL COMMENT '父id',
  `userid` varchar(64) DEFAULT NULL,
  `onlychild` char(1) DEFAULT NULL COMMENT '是否独生子女 1：是 2：否',
  `apport_type` varchar(20) DEFAULT NULL COMMENT '分摊方式',
  `deduct_amount` decimal(10,0) DEFAULT NULL COMMENT '扣除方式',
  `approve_status` char(1) DEFAULT NULL,
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL COMMENT '审核时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_hid` (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='赡养老人专项附加扣除';



# Dump of table pit_elderly_common
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_elderly_common`;

CREATE TABLE `pit_elderly_common` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL,
  `userid` varchar(64) DEFAULT NULL,
  `common_id_type` char(2) DEFAULT NULL COMMENT '身份证件类型',
  `common_id_number` varchar(18) DEFAULT NULL COMMENT '身份证件号码',
  `common_name` varchar(20) DEFAULT NULL,
  `common_country` varchar(50) DEFAULT NULL COMMENT '地址',
  `common_front_filepath` varchar(80) DEFAULT NULL COMMENT '身份证正面',
  `common_back_filepath` varchar(80) DEFAULT NULL COMMENT '身份证反面',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_hid` (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='共同赡养老人';



# Dump of table pit_elderly_dep
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_elderly_dep`;

CREATE TABLE `pit_elderly_dep` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL,
  `userid` varchar(64) DEFAULT NULL,
  `name` varchar(20) NOT NULL COMMENT '第一位赡养人姓名',
  `relationship` char(1) DEFAULT NULL COMMENT '第一位与扣除人关系，1-父亲；2-母亲；3-祖父母；4-外祖父母',
  `id_type` char(2) DEFAULT NULL COMMENT '第一位身份证类型',
  `id_number` varchar(18) DEFAULT NULL COMMENT '第一位身份证号',
  `country` varchar(50) DEFAULT NULL COMMENT '第一位地址',
  `birth` date DEFAULT NULL COMMENT '第一位出生日期',
  `id_front_filepath` varchar(80) DEFAULT NULL COMMENT '第一位身份证正面',
  `id_back_filepath` varchar(80) DEFAULT NULL COMMENT '第一位身份证反面',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_hid` (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='被赡养人';



# Dump of table pit_housing_loan
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_housing_loan`;

CREATE TABLE `pit_housing_loan` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL COMMENT '父id',
  `userid` varchar(64) DEFAULT NULL,
  `house_type` char(1) DEFAULT NULL COMMENT '房屋类型',
  `house_contract_num` varchar(40) DEFAULT NULL COMMENT '新增-产权证号/不动产登记号/商品房买卖合同号',
  `own` char(1) DEFAULT NULL COMMENT '本人是否借款人  Y：是 N：否',
  `first_house_loan` char(1) DEFAULT NULL COMMENT '是否婚前各自首套贷款  Y：是 N：否',
  `house_address` varchar(50) DEFAULT NULL COMMENT '住房地址',
  `loan_type` char(1) DEFAULT NULL COMMENT '贷款方式，1-商业代码；2-公积金贷款；3-组合贷款',
  `loan_bank` varchar(30) DEFAULT NULL COMMENT '贷款银行',
  `pf_loan_contract_num` varchar(40) DEFAULT NULL COMMENT '公积金贷款合同编号',
  `pf_loan_amont` decimal(10,2) DEFAULT NULL COMMENT '公积金贷款金额',
  `loan_month` smallint(1) unsigned DEFAULT NULL COMMENT '公积金期限',
  `repayment_date` date DEFAULT NULL COMMENT '公积金还款日期',
  `business_loan_contract_num` varchar(40) DEFAULT NULL COMMENT '商业贷款合同编号',
  `business_loan_amont` decimal(10,0) DEFAULT NULL COMMENT '商业贷款金额',
  `loan_frontpath` varchar(80) DEFAULT NULL COMMENT '贷款封面路径',
  `loan_filepath` varchar(80) DEFAULT NULL COMMENT '合同附件',
  `approve_status` char(1) DEFAULT '1' COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL COMMENT '审核时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_hid` (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='申报住房贷款信息专项附件扣除';



# Dump of table pit_housing_rent
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_housing_rent`;

CREATE TABLE `pit_housing_rent` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL COMMENT '父id',
  `userid` varchar(64) DEFAULT NULL,
  `name` varchar(20) NOT NULL COMMENT '租房人姓名',
  `area` varchar(20) DEFAULT NULL COMMENT '租住所在省、市、区',
  `address` varchar(50) DEFAULT NULL COMMENT '详细地址',
  `province` varchar(20) DEFAULT NULL COMMENT '省份',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  `type` char(1) DEFAULT NULL COMMENT '类型：个人或组织',
  `identity_type` char(2) DEFAULT NULL COMMENT '身份证件类型',
  `identity_number` varchar(18) DEFAULT NULL COMMENT '身份证件号码',
  `contract_number` varchar(30) DEFAULT NULL COMMENT '合同编号',
  `rent_start` date DEFAULT NULL COMMENT '租定起始日期',
  `rent_end` date DEFAULT NULL COMMENT '预计结束日期',
  `rent_filepath` varchar(80) DEFAULT NULL COMMENT '合同附件',
  `rent_second_filepath` varchar(80) DEFAULT NULL,
  `approve_status` char(1) DEFAULT '1' COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL COMMENT '审核时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_hid` (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='住房租金专项附加扣除';



# Dump of table pit_martyr
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_martyr`;

CREATE TABLE `pit_martyr` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL COMMENT '父id',
  `userid` varchar(64) DEFAULT NULL,
  `martyr_name` varchar(20) DEFAULT NULL COMMENT '烈士姓名',
  `martyr_relation` char(1) DEFAULT NULL COMMENT '烈士与扣除人关系，1-父母；2-抚养人；3-配偶；4-子女；5-兄弟姐妹',
  `martyr_filepath` varchar(80) DEFAULT NULL,
  `approve_status` char(1) DEFAULT '1' COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `ts` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_hid` (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='烈属相关';



# Dump of table quota_collection
# ------------------------------------------------------------

DROP TABLE IF EXISTS `quota_collection`;

CREATE TABLE `quota_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `pk_invoice` int(11) NOT NULL COMMENT '发票id',
  `fp_dm` varchar(12) DEFAULT NULL COMMENT '代码',
  `fp_hm` varchar(8) DEFAULT NULL COMMENT '号码',
  `submitter` varchar(50) DEFAULT NULL COMMENT '提交人（员工账号）',
  `submit_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `reimburse_user` varchar(50) DEFAULT NULL COMMENT '报销人',
  `reimburse_date` timestamp NULL DEFAULT NULL COMMENT '报销日期',
  `reimburse_money` decimal(15,2) DEFAULT NULL COMMENT '报销金额(2位小数)',
  `voucherid` varchar(32) DEFAULT NULL COMMENT '凭证号',
  `account_user` varchar(50) DEFAULT NULL COMMENT '记账人',
  `account_time` datetime DEFAULT NULL COMMENT '记账时间',
  `account_note` varchar(100) DEFAULT NULL COMMENT '记账备注',
  `vnote` varchar(181) DEFAULT NULL COMMENT '备注',
  `src_type` tinyint(4) DEFAULT '1' COMMENT '来源类型 1:手工界面上传；2:外系统接口调用',
  `payment_status` tinyint(4) DEFAULT '1' COMMENT '支付状态;1:未支付，2：已支付',
  `src_billtype` varchar(50) DEFAULT NULL COMMENT '来源单据类型',
  `src_billcode` varchar(30) DEFAULT NULL COMMENT '来源单据号',
  `manual_verify_status` tinyint(4) DEFAULT NULL COMMENT '手工认证状态；1-不需认证；2-未勾选；3-已勾选；4-已认证',
  `bratio` varchar(1) DEFAULT 'N' COMMENT '是否比例转出',
  `account_id` int(11) unsigned DEFAULT NULL COMMENT '科目id',
  `suspect_status` tinyint(4) DEFAULT NULL COMMENT '疑票状态:1.未通过2.已通过3.已禁止',
  `suspect_type` tinyint(4) DEFAULT NULL COMMENT '疑票类型: 1.无电子签章2.证书链不通过3.购买方纳税人识别号为空4.电子签名被篡改5.缺少销货清单6.购买方名称不符7.供应商黑名单8.发票连号9.节假日',
  `suspect_rule` varchar(100) DEFAULT NULL COMMENT '疑票规则',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`fp_hm`,`fp_dm`) USING BTREE,
  KEY `idx_corp_org_invoice` (`orgid`,`pk_invoice`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='定额发票台账';



# Dump of table real_estate_cip
# ------------------------------------------------------------

DROP TABLE IF EXISTS `real_estate_cip`;

CREATE TABLE `real_estate_cip` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) unsigned NOT NULL COMMENT '组织id',
  `pk_invoice` int(11) unsigned NOT NULL COMMENT '发票id',
  `fp_dm` varchar(12) NOT NULL COMMENT '发票代码',
  `fp_hm` varchar(8) NOT NULL COMMENT '发票号码',
  `submitter` varchar(50) DEFAULT NULL COMMENT '提交人（员工账号）',
  `submit_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `purchaser` varchar(50) DEFAULT NULL COMMENT '采购员',
  `vnote` varchar(200) DEFAULT NULL COMMENT '备注',
  `src_type` tinyint(4) DEFAULT NULL COMMENT '来源类型 1:手工界面上传；2:外系统接口调用',
  `need_verify` char(1) DEFAULT NULL COMMENT '是否需要认证；N-不需要认证，Y-需要认证；专票使用',
  `voucherid` varchar(32) DEFAULT NULL COMMENT '凭证号',
  `account_user` varchar(50) DEFAULT NULL COMMENT '记账人',
  `account_time` datetime DEFAULT NULL COMMENT '记账时间',
  `account_note` varchar(100) DEFAULT NULL COMMENT '记账备注',
  `src_billtype` varchar(10) DEFAULT NULL COMMENT '来源单据类型',
  `src_billcode` varchar(30) DEFAULT NULL COMMENT '来源单据号',
  `full_deduction` char(1) NOT NULL DEFAULT 'N' COMMENT '一次性全额抵扣',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  PRIMARY KEY (`id`),
  KEY `idx_cip_dmhm` (`fp_hm`,`fp_dm`) USING BTREE COMMENT '号码、代码索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='不动产及在建工程；\r\n在建工程（construction in process）';



# Dump of table real_estate_deduction
# ------------------------------------------------------------

DROP TABLE IF EXISTS `real_estate_deduction`;

CREATE TABLE `real_estate_deduction` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL,
  `orgid` int(11) unsigned NOT NULL,
  `pk_invoice` int(11) unsigned NOT NULL COMMENT '发票id',
  `fp_dm` varchar(12) NOT NULL COMMENT '发票代码',
  `fp_hm` varchar(8) NOT NULL COMMENT '发票号码',
  `item` varchar(10) NOT NULL COMMENT '事项；首次抵扣，二次抵扣',
  `tax_amount` decimal(15,2) NOT NULL COMMENT '抵扣税额',
  `deduct_date` datetime NOT NULL COMMENT '抵扣时间（业务时间）',
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='不动产抵扣管理';



# Dump of table real_estate_sales
# ------------------------------------------------------------

DROP TABLE IF EXISTS `real_estate_sales`;

CREATE TABLE `real_estate_sales` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL,
  `orgid` int(11) unsigned NOT NULL COMMENT '组织id',
  `pk_invoice` int(11) unsigned NOT NULL COMMENT '发票id',
  `fp_dm` varchar(12) NOT NULL COMMENT '发票代码',
  `fp_hm` varchar(8) NOT NULL COMMENT '发票号码',
  `item` varchar(10) NOT NULL,
  `tax_amount` decimal(15,2) NOT NULL COMMENT '销售税额',
  `sale_date` datetime DEFAULT NULL COMMENT '抵扣时间（业务时间）',
  `vnote` varchar(181) DEFAULT NULL COMMENT '备注',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='不动产/在建工程销售';



# Dump of table risk_warn_config
# ------------------------------------------------------------

DROP TABLE IF EXISTS `risk_warn_config`;

CREATE TABLE `risk_warn_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `warn_type` char(1) NOT NULL COMMENT '预警类型:1:进项风控预警, 2:专票获取预警',
  `trigger_condition` varchar(300) DEFAULT NULL COMMENT '触发条件',
  `enabled` char(1) DEFAULT 'N' COMMENT '是否启用：Y:启用，N:禁用',
  `corpid` varchar(64) DEFAULT NULL COMMENT '企业id',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='自动预警配置表';



# Dump of table self_check
# ------------------------------------------------------------

DROP TABLE IF EXISTS `self_check`;

CREATE TABLE `self_check` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` varchar(64) NOT NULL COMMENT '用户id',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `begin_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '自检开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '结束自检时间',
  `total_num` int(10) unsigned DEFAULT NULL COMMENT '查验总张数',
  `change_num` int(10) unsigned DEFAULT NULL COMMENT '状态变化张数',
  `exception_num` int(10) unsigned DEFAULT NULL COMMENT '查验异常张数',
  `status` tinyint(4) NOT NULL COMMENT '自检状态  0：自检中；1：已完成；2：异常中断',
  `exception_msg` varchar(255) DEFAULT NULL COMMENT '异常信息',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票自检报告主表';



# Dump of table self_check_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `self_check_detail`;

CREATE TABLE `self_check_detail` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `hid` int(10) unsigned NOT NULL COMMENT '主表主键',
  `orgid` int(11) NOT NULL COMMENT '受票组织id',
  `fplx` varchar(4) NOT NULL COMMENT '发票类型1增值税电子普通发票;3增值税普通发票;4增值税专用发票;5机动车销售统一发票;6货物运输业增值税专用发票;8成品油电子发票;9成品油普通发票(卷式);10增值税普通发票(成品油);11增值税专用发票(成品油);12增值税普通发票(卷式);14通行费发票;',
  `fp_dm` char(12) NOT NULL COMMENT '发票代码',
  `fp_hm` char(8) NOT NULL COMMENT '发票号码',
  `xsf_mc` varchar(100) NOT NULL COMMENT '销售方名称',
  `xsf_nsrsbh` char(20) NOT NULL COMMENT '销售方纳税人识别号',
  `kprq` date NOT NULL COMMENT '开票日期',
  `submit_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '提交时间',
  `jshj` decimal(15,2) NOT NULL COMMENT '价税合计',
  `hjje` decimal(15,2) NOT NULL COMMENT '合计金额',
  `jym` char(20) DEFAULT NULL COMMENT '校验码',
  `fpzt_old` tinyint(4) NOT NULL COMMENT '原发票状态；0-正常，1-失控，2-作废，3-红冲，4-异常',
  `fpzt_now` tinyint(4) NOT NULL COMMENT '现发票状态；0-正常，1-失控，2-作废，3-红冲，4-异常',
  `display` char(1) NOT NULL COMMENT '是否显示  Y：显示 N：不显示',
  `status` tinyint(4) NOT NULL COMMENT '自检状态  0：自检中；1：已完成；2：异常中断',
  `exception_msg` varchar(255) DEFAULT NULL COMMENT '异常原因',
  `src_type` tinyint(4) NOT NULL COMMENT '台账来源  1：报销；2：采购；3：不动产',
  `src_id` int(11) NOT NULL COMMENT '台账id',
  `pk_invoice` int(11) NOT NULL COMMENT '发票主键',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  KEY `index_name` (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票自检报告明细表';



# Dump of table supplier_blacklist
# ------------------------------------------------------------

DROP TABLE IF EXISTS `supplier_blacklist`;

CREATE TABLE `supplier_blacklist` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '供应商名称',
  `nsrsbh` varchar(20) NOT NULL COMMENT '税号',
  `reason` varchar(100) DEFAULT NULL COMMENT '原因',
  `corpid` varchar(64) DEFAULT NULL COMMENT '企业id',
  `submitter` varchar(64) DEFAULT NULL COMMENT '提交人',
  `submit_date` date DEFAULT NULL COMMENT '提交日期，YYYY-MM-DD',
  `src` char(1) DEFAULT NULL COMMENT '来源:1.本公司;2.税局',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_nsrsbh` (`nsrsbh`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商黑名单表';



# Dump of table suspect_invoice
# ------------------------------------------------------------

DROP TABLE IF EXISTS `suspect_invoice`;

CREATE TABLE `suspect_invoice` (
  `PK_INVOICE` int(11) NOT NULL AUTO_INCREMENT COMMENT '发票索引号',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `FP_DM` char(12) NOT NULL COMMENT '发票代码，必填',
  `FP_HM` char(8) NOT NULL COMMENT '发票号码，必填',
  `JQBH` char(12) DEFAULT NULL COMMENT '税控设备编号，必填',
  `KPRQ` date NOT NULL COMMENT '开票日期，YYYYMMDD，必填',
  `FP_MW` char(112) DEFAULT NULL COMMENT '发票密文',
  `JYM` char(20) DEFAULT NULL COMMENT '发票校验码，必填',
  `FPLX` varchar(4) NOT NULL COMMENT '发票类型1增值税电子普通发票;3增值税普通发票;4增值税专用发票;5机动车销售统一发票;6货物运输业增值税专用发票;14通行费发票;8成品油电子发票',
  `KPLX` char(1) NOT NULL COMMENT '开票类型\\n0-蓝字发票;1-红字发票',
  `FPJZ` char(1) DEFAULT '0' COMMENT '开票介质 0-电子发票；1-纸质发票',
  `XSF_NSRSBH` char(20) NOT NULL COMMENT '销售方纳税人识别号，必填',
  `XSF_MC` varchar(100) NOT NULL COMMENT '销售方名称，必填。默认值：销售方',
  `XSF_DZDH` varchar(100) DEFAULT NULL COMMENT '销售方地址、电话',
  `XSF_YHZH` varchar(100) DEFAULT NULL COMMENT '销售方银行账号',
  `GMF_NSRSBH` char(20) DEFAULT NULL COMMENT '购买方纳税人识别号',
  `GMF_MC` varchar(100) NOT NULL COMMENT '购买方名称，必填，默认值：购买方',
  `GMF_DZDH` varchar(100) DEFAULT NULL COMMENT '购买方地址、电话',
  `GMF_YHZH` varchar(100) DEFAULT NULL COMMENT '购买方银行账号',
  `KPR` varchar(20) DEFAULT NULL COMMENT '开票人',
  `SKR` varchar(20) DEFAULT NULL COMMENT '收款人',
  `FHR` varchar(20) DEFAULT NULL COMMENT '复核人',
  `YFP_DM` char(12) DEFAULT NULL COMMENT '原发票代码（红字发票必须）',
  `YFP_HM` char(8) DEFAULT NULL COMMENT '原发票代码（红字发票必须）',
  `JSHJ` decimal(15,2) NOT NULL COMMENT '价税合计-单位：元（2位小数）',
  `HJJE` decimal(15,2) NOT NULL COMMENT '合计金额',
  `HJSE` decimal(15,2) DEFAULT NULL COMMENT '合计税额',
  `BZ` varchar(230) DEFAULT NULL COMMENT '备注',
  `ZFBZ` char(1) DEFAULT 'N' COMMENT '作废标志',
  `SWJGDM` varchar(20) DEFAULT NULL COMMENT '税务机关代码',
  `SWJGMC` varchar(200) DEFAULT NULL COMMENT '税务机关名称',
  `WSPZH` varchar(32) DEFAULT NULL COMMENT '完税凭证号',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳，格式YYYYMMDDHHMMSS',
  `FILEPATH` varchar(200) DEFAULT NULL,
  `TXFBZ` varchar(2) DEFAULT NULL COMMENT '通讯费标志 06-可抵扣通行费，07-不可抵扣通行费',
  `LSLBZ` varchar(1) DEFAULT NULL COMMENT '零税率标志 空:非零税率，1-免税2-不征收3-零税率',
  PRIMARY KEY (`PK_INVOICE`),
  KEY `idx_hm_dm` (`FP_HM`,`FP_DM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题电子发票主表';



# Dump of table suspect_invoice_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `suspect_invoice_detail`;

CREATE TABLE `suspect_invoice_detail` (
  `PK_INVOICE_DETAIL` int(11) NOT NULL AUTO_INCREMENT,
  `PK_INVOICE` char(16) NOT NULL,
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `FP_DM` char(12) NOT NULL COMMENT '发票代码',
  `FP_HM` char(8) NOT NULL COMMENT '发票号码',
  `FPHXZ` char(1) NOT NULL COMMENT '发票行性质-0正常行/1折扣行/2被折扣行',
  `XMMC` varchar(90) NOT NULL COMMENT '项目名称',
  `DW` varchar(20) DEFAULT NULL COMMENT '计量单位',
  `GGXH` varchar(100) DEFAULT NULL COMMENT '规格型号',
  `XMSL` decimal(15,6) DEFAULT NULL COMMENT '项目数量',
  `XMDJ` decimal(20,10) DEFAULT NULL COMMENT '项目单价',
  `XMJE` decimal(15,2) NOT NULL COMMENT '项目金额',
  `SL` decimal(6,6) DEFAULT NULL COMMENT '税率',
  `SE` decimal(15,2) DEFAULT NULL COMMENT '税额',
  `KCE` decimal(15,2) DEFAULT NULL,
  `SPBM` varchar(19) DEFAULT NULL COMMENT '商品编码',
  `TXF_CPH` varchar(40) DEFAULT NULL COMMENT '通行费-车牌号',
  `TXF_LX` varchar(32) DEFAULT NULL COMMENT '通行费-类型',
  `TXF_TXRQQ` varchar(32) DEFAULT NULL COMMENT '通行费-通行日期起',
  `TXF_TXRQZ` varchar(32) DEFAULT NULL COMMENT '通行费-通行日期止',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`PK_INVOICE_DETAIL`),
  KEY `parent_invoice` (`PK_INVOICE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题电子发票项目明细';



# Dump of table suspect_invoice_motor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `suspect_invoice_motor`;

CREATE TABLE `suspect_invoice_motor` (
  `pk_invoice_detail` int(10) unsigned NOT NULL COMMENT '子表主键',
  `pk_invoice` int(10) unsigned NOT NULL COMMENT '发票PK',
  `cd` varchar(80) DEFAULT NULL COMMENT '产地',
  `hgzh` varchar(100) DEFAULT NULL COMMENT '合格证号',
  `jkzmsh` varchar(80) DEFAULT NULL COMMENT '进口证明书号',
  `sjdh` varchar(80) DEFAULT NULL COMMENT '商检单号',
  `fdjhm` varchar(120) DEFAULT NULL COMMENT '发动机号码',
  `cjhm` varchar(40) DEFAULT NULL COMMENT '车架号码',
  `dunwei` varchar(40) DEFAULT NULL COMMENT '吨位',
  `xcrs` varchar(40) DEFAULT NULL COMMENT '限乘人数',
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`pk_invoice_detail`),
  KEY `idx_motor_inv` (`pk_invoice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机动车明细扩展表';



# Dump of table suspect_mgmt
# ------------------------------------------------------------

DROP TABLE IF EXISTS `suspect_mgmt`;

CREATE TABLE `suspect_mgmt` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题票管理主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `pk_invoice` int(11) NOT NULL COMMENT '问题票主键',
  `submitter` varchar(50) DEFAULT '~' COMMENT '提交人',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `suspect_type` tinyint(4) DEFAULT NULL COMMENT '疑票类型, 1 无电子签章 2 证书链不通过',
  `suspect_rule` varchar(100) DEFAULT NULL COMMENT '疑票规则',
  `status` tinyint(4) DEFAULT '1' COMMENT '疑票状态1 未处理 2 已放行 3已禁止',
  `src_type` tinyint(4) DEFAULT '1' COMMENT '来源类型 1:手工界面上传；2:外系统接口调用',
  `modifier` varchar(50) DEFAULT NULL COMMENT '处理人',
  `src_billtype` varchar(50) DEFAULT NULL COMMENT '来源单据类型',
  `src_billcode` varchar(30) DEFAULT NULL COMMENT '来源单据类型',
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '处理时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  KEY `idx_suspect_mgmt_invoice` (`pk_invoice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题票管理';



# Dump of table suspect_taxi
# ------------------------------------------------------------

DROP TABLE IF EXISTS `suspect_taxi`;

CREATE TABLE `suspect_taxi` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `date` datetime DEFAULT NULL COMMENT '开票日期',
  `invoice_code` varchar(12) DEFAULT NULL COMMENT '发票代码',
  `invoice_num` varchar(8) DEFAULT NULL COMMENT '发票号码',
  `car_num` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `mileage` decimal(15,2) DEFAULT NULL COMMENT '里程',
  `start_time` varchar(20) DEFAULT NULL COMMENT '上车时间',
  `end_time` varchar(20) DEFAULT NULL COMMENT '下车时间',
  `total_amount` decimal(15,2) NOT NULL COMMENT '金额',
  `purchaser_status` tinyint(1) DEFAULT NULL COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `place` varchar(20) DEFAULT NULL COMMENT '发票所在地',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `file_path` varchar(60) DEFAULT NULL,
  `bz` varchar(200) DEFAULT NULL COMMENT '备注',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`invoice_num`,`invoice_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题出租车票表';



# Dump of table taxi_collection
# ------------------------------------------------------------

DROP TABLE IF EXISTS `taxi_collection`;

CREATE TABLE `taxi_collection` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `pk_invoice` int(11) NOT NULL COMMENT '发票id',
  `fp_dm` varchar(12) DEFAULT NULL COMMENT '代码',
  `fp_hm` varchar(8) DEFAULT NULL COMMENT '号码',
  `submitter` varchar(50) DEFAULT NULL COMMENT '提交人（员工账号）',
  `submit_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `reimburse_user` varchar(50) DEFAULT NULL COMMENT '报销人',
  `reimburse_date` timestamp NULL DEFAULT NULL COMMENT '报销日期',
  `reimburse_money` decimal(15,2) DEFAULT NULL COMMENT '报销金额(2位小数)',
  `voucherid` varchar(32) DEFAULT NULL COMMENT '凭证号',
  `account_user` varchar(50) DEFAULT NULL COMMENT '记账人',
  `account_time` datetime DEFAULT NULL COMMENT '记账时间',
  `account_note` varchar(100) DEFAULT NULL COMMENT '记账备注',
  `vnote` varchar(181) DEFAULT NULL COMMENT '备注',
  `src_type` tinyint(4) DEFAULT '1' COMMENT '来源类型 1:手工界面上传；2:外系统接口调用',
  `payment_status` tinyint(4) DEFAULT '1' COMMENT '支付状态;1:未支付，2：已支付',
  `src_billtype` varchar(50) DEFAULT NULL COMMENT '来源单据类型',
  `src_billcode` varchar(30) DEFAULT NULL COMMENT '来源单据号',
  `manual_verify_status` tinyint(4) DEFAULT NULL COMMENT '手工认证状态；1-不需认证；2-未勾选；3-已勾选；4-已认证',
  `bratio` varchar(1) DEFAULT 'N' COMMENT '是否比例转出',
  `account_id` int(11) unsigned DEFAULT NULL COMMENT '科目id',
  `suspect_status` tinyint(4) DEFAULT NULL COMMENT '疑票状态:1.未通过2.已通过3.已禁止',
  `suspect_type` tinyint(4) DEFAULT NULL COMMENT '疑票类型: 1.无电子签章2.证书链不通过3.购买方纳税人识别号为空4.电子签名被篡改5.缺少销货清单6.购买方名称不符7.供应商黑名单8.发票连号9.节假日',
  `suspect_rule` varchar(100) DEFAULT NULL COMMENT '疑票规则',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`fp_hm`,`fp_dm`) USING BTREE,
  KEY `idx_corp_org_invoice` (`orgid`,`pk_invoice`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='出租车发票台账';



# Dump of table tmp_dm_hm
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tmp_dm_hm`;

CREATE TABLE `tmp_dm_hm` (
  `sessionid` varchar(20) NOT NULL COMMENT '数据库会话id',
  `fp_dm` varchar(12) NOT NULL COMMENT '发票代码',
  `fp_hm` varchar(8) NOT NULL COMMENT '发票号码',
  KEY `idx_dm_hm` (`fp_hm`,`fp_dm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代码号码临时表';



# Dump of table tolls_collection
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tolls_collection`;

CREATE TABLE `tolls_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `pk_invoice` int(11) NOT NULL COMMENT '发票id',
  `fp_dm` varchar(12) DEFAULT NULL COMMENT '发票代码',
  `fp_hm` varchar(20) DEFAULT NULL COMMENT '发票号码',
  `submitter` varchar(50) DEFAULT NULL COMMENT '提交人（员工账号）',
  `submit_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `reimburse_user` varchar(50) DEFAULT NULL COMMENT '报销人',
  `reimburse_date` timestamp NULL DEFAULT NULL COMMENT '报销日期',
  `reimburse_money` decimal(15,2) DEFAULT NULL COMMENT '报销金额(2位小数)',
  `voucherid` varchar(32) DEFAULT NULL COMMENT '凭证号',
  `account_user` varchar(50) DEFAULT NULL COMMENT '记账人',
  `account_time` datetime DEFAULT NULL COMMENT '记账时间',
  `account_note` varchar(100) DEFAULT NULL COMMENT '记账备注',
  `vnote` varchar(181) DEFAULT NULL COMMENT '备注',
  `src_type` tinyint(4) DEFAULT '1' COMMENT '来源类型 1:手工界面上传；2:外系统接口调用',
  `payment_status` tinyint(4) DEFAULT '1' COMMENT '支付状态;1:未支付，2：已支付',
  `src_billtype` varchar(50) DEFAULT NULL COMMENT '来源单据类型',
  `src_billcode` varchar(30) DEFAULT NULL COMMENT '来源单据号',
  `manual_verify_status` tinyint(4) DEFAULT NULL COMMENT '手工认证状态；1-不需认证；2-未勾选；3-已勾选；4-已认证',
  `bratio` varchar(1) DEFAULT 'N' COMMENT '是否比例转出',
  `account_id` int(11) unsigned DEFAULT NULL COMMENT '科目id',
  `suspect_status` tinyint(4) DEFAULT NULL COMMENT '疑票状态:1.未通过2.已通过3.已禁止',
  `suspect_type` tinyint(4) DEFAULT NULL COMMENT '疑票类型: 1.无电子签章2.证书链不通过3.购买方纳税人识别号为空4.电子签名被篡改5.缺少销货清单6.购买方名称不符7.供应商黑名单8.发票连号9.节假日',
  `suspect_rule` varchar(100) DEFAULT NULL COMMENT '疑票规则',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_dm_hm` (`fp_dm`,`fp_hm`) USING BTREE,
  KEY `idx_corp_org_invoice` (`orgid`,`pk_invoice`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='过路费台账';



# Dump of table train_collection
# ------------------------------------------------------------

DROP TABLE IF EXISTS `train_collection`;

CREATE TABLE `train_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `pk_invoice` int(11) NOT NULL COMMENT '发票id',
  `number` varchar(32) NOT NULL COMMENT '火车票唯一编号',
  `submitter` varchar(50) DEFAULT NULL COMMENT '提交人（员工账号）',
  `submit_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `reimburse_user` varchar(50) DEFAULT NULL COMMENT '报销人',
  `reimburse_date` timestamp NULL DEFAULT NULL COMMENT '报销日期',
  `reimburse_money` decimal(15,2) DEFAULT NULL COMMENT '报销金额(2位小数)',
  `voucherid` varchar(32) DEFAULT NULL COMMENT '凭证号',
  `account_user` varchar(50) DEFAULT NULL COMMENT '记账人',
  `account_time` datetime DEFAULT NULL COMMENT '记账时间',
  `account_note` varchar(100) DEFAULT NULL COMMENT '记账备注',
  `vnote` varchar(181) DEFAULT NULL COMMENT '备注',
  `src_type` tinyint(4) DEFAULT '1' COMMENT '来源类型 1:手工界面上传；2:外系统接口调用',
  `payment_status` tinyint(4) DEFAULT '1' COMMENT '支付状态;1:未支付，2：已支付',
  `src_billtype` varchar(50) DEFAULT NULL COMMENT '来源单据类型',
  `src_billcode` varchar(30) DEFAULT NULL COMMENT '来源单据号',
  `manual_verify_status` tinyint(4) DEFAULT NULL COMMENT '手工认证状态；1-不需认证；2-未勾选；3-已勾选；4-已认证',
  `period` varchar(6) DEFAULT NULL COMMENT '抵扣期间',
  `bratio` varchar(1) DEFAULT 'N' COMMENT '是否比例转出',
  `account_id` int(11) unsigned DEFAULT NULL COMMENT '科目id',
  `suspect_status` tinyint(4) DEFAULT NULL COMMENT '疑票状态:1.未通过2.已通过3.已禁止',
  `suspect_type` tinyint(4) DEFAULT NULL COMMENT '疑票类型: 1.无电子签章2.证书链不通过3.购买方纳税人识别号为空4.电子签名被篡改5.缺少销货清单6.购买方名称不符7.供应商黑名单8.发票连号9.节假日',
  `suspect_rule` varchar(100) DEFAULT NULL COMMENT '疑票规则',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm` (`number`) USING BTREE,
  KEY `idx_corp_org_invoice` (`orgid`,`pk_invoice`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='火车票台账';



# Dump of table trans_deduction_statistics
# ------------------------------------------------------------

DROP TABLE IF EXISTS `trans_deduction_statistics`;

CREATE TABLE `trans_deduction_statistics` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `nsrsbh` varchar(20) NOT NULL COMMENT '纳税人识别号',
  `period` varchar(6) NOT NULL COMMENT '抵扣期间',
  `type` char(1) NOT NULL COMMENT '客票类型  1:航空；2:铁路；3:其他客票',
  `total_je_sum` decimal(15,2) DEFAULT NULL COMMENT '合计无税金额',
  `total_hjse_sum` decimal(15,2) DEFAULT NULL COMMENT '合计税额',
  `total_jshj_sum` decimal(15,2) DEFAULT NULL COMMENT '合计价税合计',
  `total_count` int(11) DEFAULT NULL COMMENT '份数',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='旅客运输服务抵扣统计表';



# Dump of table vat_corpinfo
# ------------------------------------------------------------

DROP TABLE IF EXISTS `vat_corpinfo`;

CREATE TABLE `vat_corpinfo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tax_no` varchar(20) DEFAULT NULL COMMENT '税号',
  `tax_name` varchar(100) DEFAULT NULL COMMENT '纳税人名称',
  `tax_status` char(1) DEFAULT '0' COMMENT '状态',
  `vat_method` varchar(20) DEFAULT 'client' COMMENT '认证接口方式；default：爬虫模式；changruan：长软模式；client：客户端模式',
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_tax_no` (`tax_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='长软勾选认真开通信息';



# Dump of table vat_precheck_stat
# ------------------------------------------------------------

DROP TABLE IF EXISTS `vat_precheck_stat`;

CREATE TABLE `vat_precheck_stat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nsrsbh` varchar(20) NOT NULL COMMENT '纳税人识别号',
  `precheck_status` tinyint(1) DEFAULT '0' COMMENT '预勾选解锁状态 1. 可以预勾选 0. 不可以预勾选',
  `corpid` varchar(64) NOT NULL COMMENT '集团id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `ik_nsrsbh` (`nsrsbh`) USING BTREE,
  KEY `corpid` (`corpid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预勾选权限表';

/* yt_piaoeda_einvoice_auth库 */
use yt_piaoeda_einvoice_auth;
/* einvoice_corp表 */
alter table einvoice_corp modify column `ts` varchar(20) DEFAULT 'CURRENT_TIMESTAMP' COMMENT '时间戳';
/* einvoice_user表 */
alter table einvoice_user add column `src_appid` varchar(64) DEFAULT NULL COMMENT '用户同步来源appid';
alter table einvoice_user add column `sync_yht` bit(1) DEFAULT b'1' COMMENT '同步友互通标志;0-税务平台的账号；1-同步至友互通';
drop index idx_user_weixin_unionid on einvoice_user;
ALTER TABLE einvoice_user add UNIQUE KEY `idx_user_unionid_usertype` (`unionid`,`usertype`) USING BTREE;
ALTER TABLE einvoice_user add KEY `idx_recvmail` (`recinvemail`(8)) USING BTREE;
/* ent_user_relation */
alter table ent_user_relation add KEY `idx_u_rel_userid` (`userid`(10)) USING BTREE;
/* pub_appregister */
alter table pub_appregister add column `src_type` int(11) DEFAULT '1' COMMENT '来源类型 1-默认 2-开通接口';
alter table pub_appregister add column `src_appid` varchar(64) DEFAULT NULL COMMENT '来源appid';
/* pub_appregister_b */
alter table pub_appregister_b modify column `type` varchar(10) DEFAULT 'URL' COMMENT '限制类型';

/* 创建其他的新表 */

DROP TABLE IF EXISTS `corp_mapping`;

CREATE TABLE `corp_mapping` (
  `corpid` varchar(64) NOT NULL COMMENT '公司ID',
  `to_corpid` varchar(64) DEFAULT NULL COMMENT '映射公司ID',
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`corpid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司映射表-（免登录链接用）';



# Dump of table ent_entuser_relation
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ent_entuser_relation`;

CREATE TABLE `ent_entuser_relation` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `corp_id` varchar(64) DEFAULT NULL COMMENT '租户id',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `corp_id` (`corp_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='企业用户和企业关系表';



# Dump of table ops_control
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ops_control`;

CREATE TABLE `ops_control` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `user_number` int(11) DEFAULT NULL COMMENT '员工个数',
  `tax_number` int(11) DEFAULT NULL COMMENT '税号个数',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个税员工数量限制';



# Dump of table pub_apiaccesslog_dl
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pub_apiaccesslog_dl`;

CREATE TABLE `pub_apiaccesslog_dl` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `appid` varchar(64) NOT NULL COMMENT 'appid',
  `ip` varchar(60) DEFAULT NULL COMMENT '请求ip',
  `accesstime` varchar(20) DEFAULT NULL COMMENT '请求时间',
  `requesturi` varchar(255) DEFAULT NULL COMMENT '请求的url',
  `requestdata` longblob COMMENT '请求数据',
  `signContent` longblob COMMENT '签名值',
  `originalSignContent` longblob COMMENT '签名数据原始信息',
  `vdef1` varchar(255) DEFAULT NULL COMMENT '自定义项1',
  `vdef2` varchar(255) DEFAULT NULL COMMENT '自定义项2',
  `vdef3` varchar(255) DEFAULT NULL COMMENT '自定义项3',
  `vdef4` varchar(255) DEFAULT NULL COMMENT '自定义项4',
  `vdef5` varchar(255) DEFAULT NULL COMMENT '自定义项5',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  KEY `idx_vdef1` (`vdef1`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table pub_appregister_b_void
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pub_appregister_b_void`;

CREATE TABLE `pub_appregister_b_void` (
  `id` int(11) NOT NULL COMMENT '主键',
  `hid` int(11) DEFAULT NULL COMMENT '表头主键',
  `verifykey` varchar(100) DEFAULT NULL COMMENT '关键字',
  `verifyclass` varchar(100) DEFAULT NULL COMMENT '验签类名或者验签类qualifier',
  `limit` bigint(20) DEFAULT NULL COMMENT '调用次数限制',
  `quota` bigint(20) DEFAULT NULL COMMENT '配额',
  `refresh_interval` bigint(20) DEFAULT '60' COMMENT '刷新频率',
  `type` varchar(10) DEFAULT 'URL' COMMENT '限制类型',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table pub_appregister_void
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pub_appregister_void`;

CREATE TABLE `pub_appregister_void` (
  `id` int(11) NOT NULL COMMENT '主键',
  `appid` varchar(64) NOT NULL COMMENT '应用id',
  `corpid` varchar(64) NOT NULL COMMENT '集团id',
  `publickey` longblob COMMENT '公钥',
  `signkey` varchar(64) DEFAULT NULL COMMENT 'key',
  `signtype` int(11) NOT NULL COMMENT '验签类型; 1:使用sign key 2:使用public key',
  `invaliddate` varchar(20) NOT NULL DEFAULT '2999-12-31 23:59:59' COMMENT '验证日期',
  `maxnum` int(11) DEFAULT '-1' COMMENT '最大数量',
  `verifyclass` varchar(100) DEFAULT '' COMMENT '验签类名或者验签类qualifier',
  `vnote` varchar(50) DEFAULT NULL COMMENT '备注',
  `src_appid` varchar(64) DEFAULT NULL COMMENT '来源appid',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  KEY `appvoid_appid` (`appid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table tmp_ops
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tmp_ops`;

CREATE TABLE `tmp_ops` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `corp_name` varchar(255) DEFAULT NULL,
  `fapiao_corpid` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*yt_piaoeda_invoice_bd*/
use yt_piaoeda_invoice_bd;

/* 对比yt_piaoeda_invoice_bd的表 */
/* ent_menu_role */
alter table ent_menu_role add KEY `idx_role_menu` (`roleId`,`menuId`) USING BTREE;
/* sms_template */
alter table sms_template add column `nsrsbh` varchar(20) DEFAULT NULL COMMENT '税号';
/* ent_user_role */
alter table ent_user_role add column `cas_user_id` varchar(64) DEFAULT NULL COMMENT 'cas中用户id';
alter table ent_user_role add KEY `idx_ent_user1` (`userId`,`roleId`) USING BTREE;
alter table ent_user_role add KEY `idx_cas_user` (`cas_user_id`,`roleId`);
/* org_tax_mech */
alter table org_tax_mech add KEY `idx_orgid` (`orgid`) USING BTREE COMMENT '组织ID索引';
/* org_vat_check */
alter table org_vatcheck add KEY `idx_orgid` (`orgid`) USING BTREE COMMENT '组织id索引';
/* orgnization */
alter table orgnization add KEY `idx_taxbodyid` (`tax_body_id`) USING BTREE;
/* pub_taxclass */
alter table pub_taxclass add column `zzstsgl` varchar(50) DEFAULT NULL COMMENT '优惠政策类型';
alter table pub_taxclass add column `xsyhzc` char(1) DEFAULT NULL COMMENT '享受优惠政策:Y.是;N.否';
/* qrcode_setting */
alter table qrcode_setting add column `title` varchar(100) DEFAULT NULL COMMENT '小票title';
/* tax_body */
alter table tax_body add column `is_supplychain` char(1) DEFAULT NULL COMMENT '是否开启供应链协同，1开启';
alter table tax_body modify column `bank_account` varchar(90) DEFAULT NULL COMMENT '开户行银行账号';
alter table tax_body add KEY `idx_nsrsbh` (`nsrsbh`) USING BTREE COMMENT '纳税人识别号索引';
/* tax_mech */
alter table tax_mech add column `nsrsbh` varchar(20) NOT NULL COMMENT '纳税人识别号';
alter table tax_mech add column `remain_limit` int(6) unsigned DEFAULT NULL COMMENT '空白票预警值';
/* user_org */
alter table user_org add column `cas_user_id` varchar(64) DEFAULT NULL COMMENT 'cas中用户id';
alter table user_org add KEY `idx_cas_org` (`cas_user_id`,`orgId`);

/*其他新增的表*/
DROP TABLE IF EXISTS `bd_customer`;

CREATE TABLE `bd_customer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) unsigned DEFAULT NULL COMMENT '组织id',
  `gmf_mc` varchar(100) NOT NULL COMMENT '购买方名称',
  `gmf_nsrsbh` varchar(20) DEFAULT NULL COMMENT '购买方纳税人识别号',
  `revemail` varchar(100) DEFAULT NULL COMMENT '收票邮箱',
  `revphone` varchar(40) DEFAULT NULL COMMENT '受票手机',
  `username` varchar(20) DEFAULT NULL COMMENT '客户联系人名称',
  `address` varchar(80) DEFAULT NULL COMMENT '购买方地址',
  `phone` varchar(20) DEFAULT NULL COMMENT '购买方电话',
  `dzdh` varchar(100) DEFAULT NULL COMMENT '地址电话（address+phone）',
  `bankname` varchar(60) DEFAULT NULL COMMENT '购买方开户银行',
  `bankaccount` varchar(40) DEFAULT NULL COMMENT '购买方银行账号',
  `yhzh` varchar(100) DEFAULT NULL COMMENT '银行账户（bankname+bankaccount）',
  `md5` varchar(32) DEFAULT NULL COMMENT 'md5值',
  `type` tinyint(4) NOT NULL COMMENT '类型（按照使用场景划分；1=普通开票；2=小程序预约开票）',
  `wxopenid` varchar(100) DEFAULT NULL COMMENT '微信openid',
  `wxformid` varchar(100) DEFAULT NULL COMMENT '微信小程序formid',
  `note_value` varchar(20) DEFAULT NULL COMMENT '序号（桌号、房间号）',
  `jshj` decimal(15,2) DEFAULT NULL COMMENT '可开票金额（明细的合计）',
  `common_use` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否是常用客户档案 1：常用 0：非常用',
  `zdybz` varchar(200) DEFAULT NULL COMMENT '自定义备注',
  `label` varchar(30) DEFAULT NULL COMMENT '标签',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  KEY `idx_customer_phone` (`revphone`),
  KEY `idx_cus_md5` (`md5`),
  KEY `idx_mc` (`gmf_mc`),
  KEY `idx_corpid` (`corpid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='客户档案信息';



# Dump of table bd_mar_template
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bd_mar_template`;

CREATE TABLE `bd_mar_template` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `industry` varchar(20) NOT NULL,
  `taxpayer_type` tinyint(3) unsigned DEFAULT NULL COMMENT '纳税人分类 1-一般纳税人 2-小规模纳税人',
  `name` varchar(90) DEFAULT NULL COMMENT '商品名称',
  `class_name` varchar(10) DEFAULT NULL COMMENT '商品分类名称',
  `taxclass_code` varchar(19) DEFAULT NULL COMMENT '商品税收分类编码',
  `brevitycode` varchar(10) DEFAULT NULL COMMENT '简码',
  `sl` decimal(2,2) DEFAULT NULL COMMENT '税率',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;



# Dump of table bd_marclass
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bd_marclass`;

CREATE TABLE `bd_marclass` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(10) unsigned DEFAULT NULL COMMENT '组织id',
  `pid` int(10) unsigned NOT NULL COMMENT '上级id',
  `code` varchar(20) NOT NULL COMMENT '编码',
  `name` varchar(16) NOT NULL COMMENT '分类名称',
  `bleaf` char(1) DEFAULT NULL COMMENT '是否叶子节点；Y:是，N否',
  `ismotor` char(1) DEFAULT 'N' COMMENT '是否机动车类型;Y:是，N否',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;



# Dump of table bd_material
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bd_material`;

CREATE TABLE `bd_material` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `classid` int(10) unsigned NOT NULL COMMENT '分类id',
  `mar_code` varchar(90) DEFAULT NULL COMMENT '商品编码',
  `name` varchar(90) NOT NULL COMMENT '商品名称',
  `taxclasscode` varchar(19) NOT NULL COMMENT '商品税收分类编码',
  `brevitycode` varchar(90) DEFAULT NULL COMMENT '简码',
  `sl` decimal(6,6) DEFAULT NULL COMMENT '税率',
  `dj` decimal(20,10) DEFAULT NULL COMMENT '单价',
  `ggxh` varchar(40) DEFAULT NULL,
  `dw` varchar(20) DEFAULT NULL,
  `lslbs` char(1) DEFAULT NULL COMMENT '零税率标识；空：非零利率，0：出口退税，1：免税，2：不征收，3普通零税率',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `zzstsgl` varchar(50) DEFAULT NULL COMMENT '优惠政策类型',
  `xsyhzc` char(1) DEFAULT NULL COMMENT '享受优惠政策:Y.是;N.否',
  PRIMARY KEY (`id`),
  UNIQUE KEY `corpid` (`corpid`,`mar_code`),
  KEY `idx_marname` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;



# Dump of table bd_material_motor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bd_material_motor`;

CREATE TABLE `bd_material_motor` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `material_id` int(11) unsigned NOT NULL,
  `cllx` varchar(40) DEFAULT NULL COMMENT '车辆类型',
  `cpxh` varchar(60) DEFAULT NULL COMMENT '厂牌型号',
  `cd` varchar(80) DEFAULT NULL COMMENT '产地',
  `scqymc` varchar(240) DEFAULT NULL COMMENT '生产企业名称',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_materialid` (`material_id`) USING BTREE COMMENT '扩展表物料id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品档案扩展机动车';



# Dump of table contract
# ------------------------------------------------------------

DROP TABLE IF EXISTS `contract`;

CREATE TABLE `contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `code` varchar(50) NOT NULL COMMENT '合同编号',
  `name` varchar(550) NOT NULL COMMENT '合同名称',
  `amount` decimal(15,2) DEFAULT NULL COMMENT '合同金额',
  `valid_date` varchar(10) DEFAULT NULL COMMENT '合同有效期',
  `payment_type` char(1) DEFAULT NULL COMMENT '收支类型 1：收入类；2：支出类',
  `contract_type` varchar(2) DEFAULT NULL COMMENT '合同类型\r\n1采购合同;2销售合同;3加工合同;4承揽合同;5建设工程勘察合同;6建设工程设计合同;7建筑安装工程承包合同;8财产租赁合同;9货物运输合同;10仓储保管合同;11借款合同;12财产保险合同;13技术合同;14产权转移书据;15不征税合同;',
  `voucher_type` varchar(2) DEFAULT NULL COMMENT '应税凭证类型\r\n1购销合同;2加工承揽合同;3建设工程勘察设计合同;4建筑安装工程承包合同;5财产租赁合同;6货物运输合同;7仓储保管合同;8借款合同;9财产保险合同;10技术合同;11产权转移书据;12不征税合同;',
  `relative_name` varchar(600) DEFAULT NULL COMMENT '合同向对方名称',
  `relative_nsrsbh` varchar(20) DEFAULT NULL COMMENT '合同向对方税号',
  `contract_status` char(1) DEFAULT NULL COMMENT '合同状态  1：正常；2：终止',
  `isframe` char(1) DEFAULT NULL COMMENT '是否框架合同 N：否；Y：是',
  `sign_date` varchar(10) DEFAULT NULL COMMENT '合同签订日期',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  `file_path` varchar(255) DEFAULT NULL COMMENT '合同保存路径',
  `project_id` int(11) DEFAULT NULL COMMENT '关联项目id',
  `subproject_id` int(11) DEFAULT NULL COMMENT '关联分包管理id',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同管理主表';



# Dump of table contract_b
# ------------------------------------------------------------

DROP TABLE IF EXISTS `contract_b`;

CREATE TABLE `contract_b` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `hid` int(11) NOT NULL,
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `busi_date` varchar(10) DEFAULT NULL COMMENT '合同金额发生日期',
  `busi_amount` decimal(15,2) DEFAULT NULL COMMENT '发生金额',
  `item_note` varchar(200) DEFAULT NULL COMMENT '明细备注',
  `stamp_id` int(11) DEFAULT NULL COMMENT '关联印花税id',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同管理子表';



# Dump of table invoice_inventory
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_inventory`;

CREATE TABLE `invoice_inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nsrsbh` varchar(20) DEFAULT NULL COMMENT '纳税人识别号',
  `invoice_type` varchar(4) DEFAULT NULL COMMENT '发票类型',
  `tax_mech_code` varchar(20) DEFAULT NULL COMMENT '税控设备编码',
  `inventory_date_begin` date DEFAULT NULL COMMENT '盘点开始日期，YYYY-MM-DD',
  `inventory_date_end` date DEFAULT NULL COMMENT '盘点结束日期，YYYY-MM-DD',
  `bz` varchar(200) DEFAULT NULL COMMENT '备注',
  `pdr` varchar(64) DEFAULT NULL COMMENT '盘点人',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_nsrsbh` (`nsrsbh`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票盘点表';



# Dump of table invoice_inventory_b
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_inventory_b`;

CREATE TABLE `invoice_inventory_b` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `inventory_id` int(11) unsigned NOT NULL COMMENT '发票盘点表主键',
  `start_no` varchar(8) NOT NULL COMMENT '起始号码',
  `end_no` varchar(8) NOT NULL COMMENT '终止号码',
  `type` char(1) NOT NULL COMMENT '类型: 1、购买；2、使用；3、作废；4、结余',
  `amount` int(11) DEFAULT NULL COMMENT '发票份数',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_inventoryid` (`inventory_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票盘点明细表';



# Dump of table invoice_inventory_bak
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_inventory_bak`;

CREATE TABLE `invoice_inventory_bak` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nsrsbh` varchar(20) DEFAULT NULL COMMENT '纳税人识别号',
  `invoice_type` varchar(4) DEFAULT NULL COMMENT '发票类型',
  `tax_mech_code` varchar(20) DEFAULT NULL COMMENT '税控设备编码',
  `inventory_date_begin` date DEFAULT NULL COMMENT '盘点开始日期，YYYY-MM-DD',
  `inventory_date_end` date DEFAULT NULL COMMENT '盘点结束日期，YYYY-MM-DD',
  `bz` varchar(200) DEFAULT NULL COMMENT '备注',
  `pdr` varchar(64) DEFAULT NULL COMMENT '盘点人',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_nsrsbh` (`nsrsbh`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票盘点回写表';



# Dump of table invoice_inventory_bak_b
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_inventory_bak_b`;

CREATE TABLE `invoice_inventory_bak_b` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `inventory_id` int(11) unsigned NOT NULL COMMENT '发票盘点表主键',
  `start_no` varchar(8) NOT NULL COMMENT '起始号码',
  `end_no` varchar(8) NOT NULL COMMENT '终止号码',
  `type` char(1) NOT NULL COMMENT '类型: 1、购买；2、使用；3、作废；4、结余',
  `amount` int(11) DEFAULT NULL COMMENT '发票份数',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_inventoryid` (`inventory_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票盘点明细回写表';



# Dump of table org_default_material
# ------------------------------------------------------------

DROP TABLE IF EXISTS `org_default_material`;

CREATE TABLE `org_default_material` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `material_id` int(10) unsigned NOT NULL,
  `orgid` int(11) NOT NULL DEFAULT '0' COMMENT '组织id；0 为全局',
  `editable` char(1) NOT NULL COMMENT 'Y:可编辑;N:不可编辑',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_materialid` (`material_id`),
  KEY `idx_orgid` (`orgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='组织默认商品';



# Dump of table org_material_rel
# ------------------------------------------------------------

DROP TABLE IF EXISTS `org_material_rel`;

CREATE TABLE `org_material_rel` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `material_id` int(10) unsigned NOT NULL,
  `orgid` int(11) NOT NULL DEFAULT '0' COMMENT '组织id；0 为全局',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_materialid` (`material_id`),
  KEY `idx_orgid` (`orgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品组织分类关系';



# Dump of table pur_supply_co
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pur_supply_co`;

CREATE TABLE `pur_supply_co` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `supplier_corpid` varchar(64) NOT NULL COMMENT '供应商租户id',
  `supplier_nsrsbh` varchar(20) NOT NULL COMMENT '供应商税号',
  `supplier_code` varchar(50) DEFAULT NULL COMMENT '供应商编码',
  `purchaser_corpid` varchar(64) NOT NULL COMMENT '采购方租户id',
  `purchaser_nsrsbh` varchar(20) NOT NULL COMMENT '采购方税号',
  `purchaser_orgid` varchar(36) DEFAULT NULL COMMENT '采购受票组织id',
  `account_type` char(1) DEFAULT '0' COMMENT '台账入账类型;0-采购台账;1-报销台账;',
  `apply_date` date DEFAULT NULL COMMENT '申请时间',
  `approve_status` char(1) NOT NULL DEFAULT '0' COMMENT '审批状态；0-未关联;1-审核种;2-已关联;3-未通过',
  `approve_date` datetime DEFAULT NULL COMMENT '审批通过日期',
  `unapproved_reason` varchar(100) DEFAULT NULL COMMENT '审批不通过原因',
  `vnote` varchar(100) DEFAULT NULL COMMENT '备注',
  `contact_number` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购供应协同关系';



# Dump of table tax_exemption_policy
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tax_exemption_policy`;

CREATE TABLE `tax_exemption_policy` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `serial_no` int(5) DEFAULT NULL COMMENT '序号',
  `income_kind` varchar(30) DEFAULT NULL COMMENT '收入种类',
  `major_category` varchar(30) DEFAULT NULL COMMENT '减免政策大类',
  `minor_category` varchar(30) DEFAULT NULL COMMENT '减免政策小类',
  `property_code` varchar(8) DEFAULT NULL COMMENT '减免性质代码',
  `policy_name` varchar(100) DEFAULT NULL COMMENT '政策名称',
  `preference_clause` varchar(100) DEFAULT NULL COMMENT '优惠条款',
  `item_name` varchar(200) DEFAULT NULL COMMENT '减免项目名称',
  `relevant_policy_clause` varchar(300) DEFAULT NULL COMMENT '关联政策条款',
  `valid_date_begin` varchar(20) DEFAULT NULL COMMENT '有效期起',
  `valid_date_end` varchar(20) DEFAULT NULL COMMENT '有效期止',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='减免税政策';

/*一些bd和cas需要执行的脚本*/
/**个人用户升级**/
use yt_piaoeda_einvoice_auth;

UPDATE einvoice_user
SET sync_yht = TRUE
WHERE
    einvoice_user.usertype IN ( 2, 3, 4)
    AND sync_yht IS NULL;


UPDATE einvoice_user
set sync_yht = FALSE
WHERE
einvoice_user.usertype in (1)
and sync_yht is null;

insert into ent_entuser_relation (user_id,corp_id)
select userid as user_id,belongtocorp as corp_id
from einvoice_user
where einvoice_user.usertype != "1" and einvoice_user.belongtocorp is not null;

use yt_piaoeda_invoice_bd;

update user_org,business_user
set user_org.cas_user_id = business_user.`code`
where user_org.userId = business_user.id
and business_user.`code` not in ('zhj_001','zhj_002');

update ent_user_role,business_user
set ent_user_role.cas_user_id = business_user.`code`
where ent_user_role.userId = business_user.id
and business_user.`code` not in ('zhj_001','zhj_002');

update user_org,yt_piaoeda_einvoice_auth.einvoice_user
set user_org.cas_user_id = yt_piaoeda_einvoice_auth.einvoice_user.userid
where user_org.cas_user_id = yt_piaoeda_einvoice_auth.einvoice_user.usercode
and yt_piaoeda_einvoice_auth.einvoice_user.usertype != "1";

update ent_user_role,yt_piaoeda_einvoice_auth.einvoice_user
set ent_user_role.cas_user_id = yt_piaoeda_einvoice_auth.einvoice_user.userid
where ent_user_role.cas_user_id = yt_piaoeda_einvoice_auth.einvoice_user.usercode
and yt_piaoeda_einvoice_auth.einvoice_user.usertype != "1";

/*diwork的档案迁移*/
insert into yt_piaoeda_invoice_bd.bd_customer(`id`, `corpid`, `orgid`, `gmf_mc`, `gmf_nsrsbh`, `revemail`, `revphone`, `username`, `address`, `phone`, `dzdh`, `bankname`, `bankaccount`, `yhzh`, `md5`, `type`, `wxopenid`, `wxformid`, `note_value`, `jshj`, `zdybz`, `createtime`, `ts`) (select `id`, `corpid`, `orgid`, `gmf_mc`, `gmf_nsrsbh`, `revemail`, `revphone`, `username`, `address`, `phone`, `dzdh`, `bankname`, `bankaccount`, `yhzh`, `md5`, `type`, `wxopenid`, `wxformid`, `note_value`, `jshj`, `zdybz`, `createtime`, `ts` from yt_piaoeda_piaoeda_client.bd_customer);
insert into yt_piaoeda_invoice_bd.bd_marclass(`id`, `corpid`, `orgid`, `pid`, `code`, `name`, `bleaf`, `createtime`, `ts`) (select `id`, `corpid`, `orgid`, `pid`, `code`, `name`, `bleaf`, `createtime`, `ts` from yt_piaoeda_piaoeda_client.bd_marclass);
insert into yt_piaoeda_invoice_bd.bd_material(`id`, `corpid`, `classid`, `mar_code`, `name`, `taxclasscode`, `brevitycode`, `sl`, `dj`, `ggxh`, `dw`, `lslbs`, `createtime`, `ts`) (select `id`, `corpid`, `classid`, `name`, `name`, `taxclasscode`, `brevitycode`, `sl`, `dj`, `ggxh`, `dw`, `lslbs`, `createtime`, `ts` from yt_piaoeda_piaoeda_client.bd_material);

/*对比bd库中通用表中新加入的属性*/
/*ent_menu*/
INSERT INTO `ent_menu` (`id`, `parent_id`, `name`, `sort`, `href`, `icon`, `isshow`, `isvirtual`, `isexp`, `isdefault`, `appname`, `createtime`, `ts`)
VALUES
	(71, 0, '个税申报', 6290, '#/dataReport/dataReport_wb', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'N', '个人所得税管理', '2019-02-21 20:11:29', '2019-02-21 20:11:29'),
	(72, 0, '发票自检', 7700, '#/selfInspection/selfInspection', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '风控预警', '2019-02-28 20:03:05', '2019-02-28 20:04:10'),
	(73, 0, '自动预警', 7800, '#/autoWarning/autoWarning_wb', 'glyphicon glyphicon-th', 'Y', 'N', 'N', 'Y', '风控预警', '2019-03-19 21:25:39', '2019-03-19 21:25:39'),
	(75, 0, '供应商黑名单', 7900, '#/supplierBlacklist/supplierBlacklist_wb', 'glyphicon glyphicon-th', 'Y', 'N', 'N', 'Y', '风控预警', '2019-04-03 14:19:29', '2019-04-03 14:19:29'),
	(76, 0, '客运服务抵扣', 5310, '#/transDeduction/transDeduction_wb', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '增值税管理|进项认证管理', '2017-08-14 13:05:59', '2019-04-09 13:58:24'),
	(77, 0, '客运服务抵扣统计表', 5320, '#/transDeductionStatistics/transDeductionStatistics_wb', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '增值税管理|进项认证管理', '2017-08-14 13:05:59', '2019-04-09 13:58:24'),
	(78, 0, '项目信息', 5910, '#/projectInfo/ProjectInfo', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '涉税项目管理', '2019-05-27 10:14:34', '2019-05-27 10:14:54'),
	(79, 0, '分包管理台账', 5920, '#/subproject/Subproject', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '涉税项目管理|分包管理', '2019-05-27 10:14:34', '2019-08-26 15:05:42'),
	(80, 0, '预缴管理', 5930, '#/prepayment/Prepayment', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '涉税项目管理', '2019-05-27 10:14:34', '2019-05-27 10:15:11'),
	(81, 0, '跨地区涉税事项预警', 5915, '#/project/ProjectWarning', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '涉税项目管理', '2019-05-27 10:14:34', '2019-05-27 10:15:11'),
	(82, 0, '短信交付查询', 2820, '#/ShortMessageEnquiry', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '企业开票|交付查询', '2019-06-17 20:12:53', '2019-06-17 20:12:53'),
	(83, 0, '邮件交付查询', 2840, '#/MailEnquiry', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '企业开票|交付查询', '2019-06-17 20:12:53', '2019-06-17 20:12:53'),
	(84, 0, '专票红字信息表', 2450, '#/redinfoApply/RedinfoApply', 'glyphicon glyphicon-indent-right', 'Y', 'N', 'N', 'Y', '企业开票|开具红票', '2019-06-17 20:13:19', '2019-06-17 20:13:19'),
	(85, 0, '增值税普通发票(卷式-泰华)', 2256, '#/handInvoice/volumeInvoice', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'N', '企业开票|开具蓝票', '2019-07-02 15:54:28', '2019-07-02 15:54:28'),
	(86, 0, '采购商关系', 6293, '#/buyerRelationship/BuyerRelationship', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'N', '供应链协同', '2019-07-16 18:31:45', '2019-07-16 18:31:45'),
	(87, 0, '供应商关系', 6295, '#/supplierProfile/SupplierProfile', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'N', '供应链协同', '2019-07-16 18:31:45', '2019-07-16 18:31:45'),
	(88, 0, '合同管理', 8660, '#/contractManage/contractMange_wb', 'glyphicon glyphicon-th', 'Y', 'N', 'N', 'Y', '应用设置', '2019-07-19 10:55:39', '2019-07-19 10:55:39'),
	(89, 0, '合规校验', 7950, '#/compliance-check', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'N', '风控预警', '2019-08-06 14:19:45', '2019-08-06 14:19:45'),
	(90, 0, '印花税台账', 6291, '#/stampTaxManage/stampTaxManage', 'glyphicon glyphicon-indent-left', 'Y', 'N', 'N', 'Y', '小税种管理|印花税管理', '2019-08-06 14:19:24', '2019-08-06 14:19:24'),
	(91, 0, '异地缴纳', 6292, '#/taxPaymentInDifferentPlace/taxPaymentInDifferentPlace', 'glyphicon glyphicon-indent-left', 'Y', 'N', 'N', 'Y', '小税种管理|印花税管理', '2019-08-06 14:19:24', '2019-08-06 14:19:24'),
	(92, 0, '印花税申报表', 6725, '#/stampDutyReport/stampDutyReport', 'glyphicon glyphicon-indent-left', 'Y', 'N', 'N', 'Y', '纳税申报', '2019-08-06 14:19:24', '2019-08-06 14:19:24'),
	(93, 0, '附加税费申报表', 6750, '#/eduSurtaxReport/eduSurtaxReport', 'glyphicon glyphicon-indent-left', 'Y', 'N', 'N', 'Y', '纳税申报', '2019-08-06 14:19:24', '2019-08-06 14:19:24'),
	(94, 0, '分包发票扣除清单', 5925, '#/invoiceDedutionList/InvoiceDedutionList', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'N', '涉税项目管理|分包管理', '2019-08-26 15:06:01', '2019-08-26 15:06:01'),
	(95, 0, '进项发票查询', 5913, '#/inputInvoiceQuery/InputInvoiceQuery', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'N', '涉税项目管理|项目发票查询', '2019-08-26 15:06:01', '2019-08-26 15:06:01'),
	(96, 0, '减免税政策', 8665, '#/taxExemptionPolicy/taxExemptionPolicy', 'glyphicon glyphicon-th', 'Y', 'N', 'N', 'Y', '应用设置', '2019-09-24 13:18:59', '2019-09-24 13:18:59'),
	(97, 0, '房产台账', 6294, '#/housingPropertyTax/housingPropertyTax', 'glyphicon glyphicon-th', 'Y', 'N', 'N', 'Y', '小税种管理|房产税管理', '2019-09-24 13:22:29', '2019-09-24 13:22:29'),
	(98, 0, '土地台账', 6295, '#/land-tax-manage/LandTaxManage', 'glyphicon glyphicon-th', 'Y', 'N', 'N', 'Y', '小税种管理|土地使用税管理', '2019-09-06 17:00:07', '2019-09-18 10:14:23'),
	(99, 0, '机动车销售统一发票', 2257, '#/handInvoice/handByInvType_wb/5', 'glyphicon glyphicon-indent-left', 'Y', 'N', 'N', 'Y', '企业开票|开具蓝票', '2019-06-24 13:43:47', '2019-10-15 15:53:06'),
	(100, 0, '文化事业建设费申报表', 6760, '#/cultrualTaxDeclare/CultrualTaxDeclare', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '纳税申报', '2019-10-15 14:30:21', '2019-10-15 15:05:29'),
	(101, 0, '工会经费申报表', 6770, '#/labourUnionTax/LabourUnionTax', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '纳税申报', '2019-10-15 14:30:21', '2019-10-15 15:05:33'),
	(102, 0, '销项发票查询', 5914, '#/vatInvoiceQuery/vatInvoiceQuery', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'N', '涉税项目管理|项目发票查询', '2019-10-31 14:29:46', '2019-10-31 14:29:46'),
	(103, 0, '预勾选', 4800, '#/checkAhead/checkAhead', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '增值税管理|进项认证管理', '2017-08-14 13:02:57', '2019-05-28 00:09:45'),
	(104, 0, '应交增值税统计表', 5940, '#/payableTaxStatist/PayableTaxStatist', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '涉税项目管理', '2019-11-23 13:56:04', '2019-11-23 13:56:04'),
	(105, 0, '一般税负率统计表', 5950, '#/taxBearingRateStatist/TaxBearingRateStatist/byOrg', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '涉税项目管理|税负率统计表', '2019-11-23 13:56:04', '2019-12-12 19:57:18'),
	(106, 0, '退税勾选', 5150, '#/taxRebateCheck/TaxRebateCheck', 'glyphicon glyphicon-th', 'Y', 'N', 'N', 'Y', '增值税管理|进项认证管理', '2019-12-12 20:08:25', '2019-12-12 20:09:33'),
	(108, 0, '上传申报表', 7600, '#/uploadDeclarationForm/UploadDeclarationForm', 'glyphicon glyphicon-th', 'Y', 'N', 'N', 'Y', '风控预警|申报表比对分析', '2019-12-12 20:08:34', '2019-12-12 20:08:34'),
	(109, 0, '按核算单位税负率统计表', 5960, '#/taxBearingRateStatist/TaxBearingRateStatist/byPro', 'glyphicon glyphicon-heart-empty', 'Y', 'N', 'N', 'Y', '涉税项目管理|税负率统计表', '2019-12-12 19:57:33', '2019-12-12 19:57:33'),
	(111, 0, '申报表比对分析', 7601, '#/declarationAnalyse/DeclarationAnalyse', 'glyphicon glyphicon-th', 'Y', 'N', 'N', 'N', '风控预警|申报表比对分析', '2019-12-12 19:44:45', '2019-12-12 20:09:28');

/*ent_perm*/
INSERT INTO `ent_perm` (`id`, `menu_id`, `name`, `perm_code`, `create_time`, `ts`)
VALUES
	(5, 4, '退回', 'output-tax:invoiceapply:back', '2018-11-02 01:02:23', '2019-04-16 22:48:30'),
	(6, 13, '报销', 'input-tax:reimburse:reimbursement', '2018-12-11 20:39:04', '2019-04-16 22:48:30'),
	(7, 13, '撤销', 'input-tax:reimburse:unreimbursement', '2018-12-11 20:39:05', '2019-04-16 22:48:30'),
	(8, 17, '记账', 'input-tax:purchase-account:account', '2018-12-11 20:39:05', '2019-04-16 22:48:30'),
	(9, 17, '反记账', 'input-tax:purchase-account:unaccount', '2018-12-11 20:39:05', '2019-04-16 22:48:30'),
	(12, 37, '保存', 'output-tax:generalinvoice:save', '2019-03-19 21:29:22', '2019-04-16 22:48:30'),
	(13, 37, '开票', 'output-tax:generalinvoice:invoicing', '2019-03-19 21:29:22', '2019-04-16 22:48:30'),
	(14, 38, '保存', 'output-tax:specialinvoice:save', '2019-03-19 21:29:22', '2019-04-16 22:48:30'),
	(15, 38, '开票', 'output-tax:specialinvoice:invoicing', '2019-03-19 21:29:22', '2019-04-16 22:48:30');
INSERT INTO `ent_perm` (`id`, `menu_id`, `name`, `perm_code`, `create_time`, `ts`)
VALUES
  (22, 40, '保存', 'output-tax:dzsginvoice:save', '2019-03-19 21:29:22', '2019-04-16 22:48:31'),
  (23, 40, '开票', 'output-tax:dzsginvoice:invoicing', '2019-03-19 21:29:22', '2019-04-16 22:48:31'),
  (24, 21, '编辑', 'input-tax:personal-tax:dateuptate', '2019-04-16 22:48:03', '2019-04-16 22:48:03'),
  (25, 17, '强制删除', 'input-tax:purchase-account:force-deletion', '2019-06-17 20:12:40', '2019-06-17 20:12:40'),
  (26, 13, '强制删除', 'input-tax:reimburse:force-deletion', '2019-06-17 20:12:40', '2019-06-17 20:12:40'),
  (27, 54, '强制删除', 'input-tax:realestate:force-deletion', '2019-06-17 20:12:40', '2019-06-17 20:12:40'),
  (28, 99, '开票', 'output-tax:motorinvoice:invoicing', '2019-10-09 10:51:48', '2019-10-15 15:16:31'),
  (29, 99, '保存', 'output-tax:motorinvoice:save', '2019-10-09 10:57:15', '2019-10-15 15:16:33'),
  (30, 25, '选择锁定预勾选/解锁预勾选按钮', 'input-tax:vatcheck:ygxcheck', '2019-10-18 17:24:54', '2019-10-18 17:24:54'),
  (31, 80, '记账', 'building:prepayment:account', '2019-12-12 20:21:34', '2019-12-12 20:21:34');

  UPDATE ent_perm SET name='反记账' WHERE id=1 AND menu_id=13;
  UPDATE ent_perm SET name='记账' WHERE id=2 AND menu_id=13;
  UPDATE ent_perm SET name='保存' WHERE id=3 AND menu_id=2;
  UPDATE ent_perm SET name='开票' WHERE id=4 AND menu_id=2;
  UPDATE ent_perm SET name='退回' WHERE id=5 AND menu_id=4;
  UPDATE ent_perm SET name='报销' WHERE id=6 AND menu_id=13;
  UPDATE ent_perm SET name='撤销' WHERE id=7 AND menu_id=13;
  UPDATE ent_perm SET name='记账' WHERE id=8 AND menu_id=17;
  UPDATE ent_perm SET name='反记账' WHERE id=9 AND menu_id=17;
  UPDATE ent_perm SET name='保存' WHERE id=12 AND menu_id=37;
  UPDATE ent_perm SET name='开票' WHERE id=13 AND menu_id=37;
  UPDATE ent_perm SET name='保存' WHERE id=14 AND menu_id=38;
  UPDATE ent_perm SET name='开票' WHERE id=15 AND menu_id=38;
  UPDATE ent_perm SET name='保存' WHERE id=16 AND menu_id=42;
  UPDATE ent_perm SET name='开票' WHERE id=17 AND menu_id=42;
  UPDATE ent_perm SET name='保存' WHERE id=18 AND menu_id=69;
  UPDATE ent_perm SET name='开票' WHERE id=19 AND menu_id=69;
  UPDATE ent_perm SET name='保存' WHERE id=20 AND menu_id=70;
  UPDATE ent_perm SET name='开票' WHERE id=21 AND menu_id=70;
  UPDATE ent_perm SET name='保存' WHERE id=22 AND menu_id=40;
  UPDATE ent_perm SET name='开票' WHERE id=23 AND menu_id=40;
  UPDATE ent_perm SET name='编辑' WHERE id=24 AND menu_id=21;

  /*接下来更新output库的相关库表脚本*/
  use yt_piaoeda_piaoeda_client;
  /*einvoice_apply*/
  alter table einvoice_apply add column `hzxxbbh` varchar(30) DEFAULT NULL COMMENT '红字信息表编号';
  alter table einvoice_apply add KEY `idx_lyid` (`LYID`);
  drop index idx_orgid on einvoice_apply;
  alter table einvoice_apply add KEY `idx_orgid_zdrq` (`orgId`,`ZDRQ`) USING BTREE;
  /*einvoice_his*/
  alter table einvoice_his modify column `ID` bigint(20) unsigned NOT NULL;
  alter table einvoice_his add column `account_status` char(1) DEFAULT NULL COMMENT '1-未记账；2-已记账';
  alter table einvoice_his add column `hzxxbbh` varchar(30) DEFAULT NULL COMMENT '红字信息表编号';
  drop index idx_orgid on einvoice_his;
  alter table einvoice_his add KEY `idx_lyid` (`LYID`);
  alter table einvoice_his add KEY `idx_org_kprq` (`orgId`,`KPRQ`);
  /*einvoice_his_b*/
  alter table einvoice_his_b modify column `ID` bigint(20) unsigned NOT NULL;
  alter table einvoice_his_b modify column `HID` bigint(20) unsigned DEFAULT NULL;
  /*equivalent_sale*/
  alter table equivalent_sale modify column `sale_classification` char(1) DEFAULT NULL COMMENT '销项分类';
  /*gather_record*/
  alter table gather_record add column `orgid` int(10) DEFAULT NULL COMMENT '组织ID';
  alter table gather_record add column `gather_count` int(11) DEFAULT NULL COMMENT '当次采集所采集到的数量';
  /*invoice*/
  alter table invoice add column `ZFRQ` datetime DEFAULT NULL COMMENT '作废日期';
  alter table invoice add KEY `idx_xsfnsrsbh` (`XSF_NSRSBH`);
  /*invoice_detail*/
  alter table invoice_detail add column `YHZCBS` int(1) DEFAULT '0' COMMENT '优惠政策标识';
  alter table invoice_detail add column `ZZSTSGL` varchar(50) DEFAULT NULL COMMENT '增值税特殊管理';
  /*invoice_detail_motor*/
  alter table invoice_detail_motor add column `cllx` varchar(40) DEFAULT NULL COMMENT '车辆类型';
  alter table invoice_detail_motor add column `cpxh` varchar(60) DEFAULT NULL COMMENT '厂牌型号';
  alter table invoice_detail_motor add column `scqymc` varchar(240) DEFAULT NULL COMMENT '生产企业名称';
  alter table invoice_detail_motor add column `sfzhm` varchar(22) DEFAULT NULL COMMENT '身份证号码/组织机构代码';
  alter table invoice_detail_motor add column `dz` varchar(80) DEFAULT NULL COMMENT '地址';
  alter table invoice_detail_motor add column `dh` varchar(40) DEFAULT NULL COMMENT '电话';
  alter table invoice_detail_motor add column `khyh` varchar(80) DEFAULT NULL COMMENT '开户银行';
  alter table invoice_detail_motor add column `zh` varchar(40) DEFAULT NULL COMMENT '账户';
  /*invoice_ext*/
  alter table invoice_ext add column `selfcheckstatus` int(11) DEFAULT NULL COMMENT '自检状态';
  /*msg_email*/
  alter table msg_email add KEY `idx_createtime` (`corpid`,`createtime`) USING BTREE COMMENT '创建时间索引';
  /*msg_sms*/
  alter table msg_sms add KEY `idx_createtime` (`corpid`,`createtime`) USING BTREE COMMENT '创建时间索引';
  /*msg_url*/
  alter table msg_url add column `success` char(1) DEFAULT NULL COMMENT '回调结果是够成功。Y-成功，N-不成功';
  alter table msg_url add column `method` varchar(200) DEFAULT NULL;
  alter table msg_url add column `intf` varchar(200) DEFAULT NULL;
  alter table msg_url add KEY `idx_createtime` (`corpid`,`createtime`);
  /*pub_taxclass*/
  alter table pub_taxclass add column `zzstsgl` varchar(50) DEFAULT NULL COMMENT '优惠政策类型';
  alter table pub_taxclass add column `xsyhzc` char(1) DEFAULT NULL COMMENT '享受优惠政策:Y.是;N.否';
  /*reserve_items*/
  alter table reserve_items add column `xmsl` decimal(15,6) DEFAULT NULL COMMENT '项目数量';
  alter table reserve_items add column `xmhsdj` decimal(20,10) DEFAULT NULL COMMENT '项目含税单价';
  /*reserve_setting*/
  alter table reserve_setting add column `all_material` char(1) NOT NULL DEFAULT 'N' COMMENT '是否可选择所有商品';
  alter table reserve_setting add column `default_jshj` decimal(15,2) DEFAULT NULL COMMENT '默认表体价税合计';
  alter table reserve_setting add column `dj_sl_editable` char(1) NOT NULL DEFAULT 'N' COMMENT '单价数量是否可编辑';

  /*将新加的output库的表添加进去*/
  DROP TABLE IF EXISTS `einvoice_apply_b_motor`;

CREATE TABLE `einvoice_apply_b_motor` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `hid` int(11) unsigned NOT NULL COMMENT '发票子表id',
  `sfzhm` varchar(22) DEFAULT NULL COMMENT '身份证号码/组织机构代码',
  `cd` varchar(80) DEFAULT NULL COMMENT '产地',
  `hgzh` varchar(100) DEFAULT NULL COMMENT '合格证号',
  `jkzmsh` varchar(80) DEFAULT NULL COMMENT '进口证明书号',
  `sjdh` varchar(80) DEFAULT NULL COMMENT '商检单号',
  `fdjhm` varchar(120) DEFAULT NULL COMMENT '发动机号码',
  `cjhm` varchar(40) DEFAULT NULL COMMENT '车架号码',
  `dunwei` varchar(40) DEFAULT NULL COMMENT '吨位',
  `xcrs` varchar(40) DEFAULT NULL COMMENT '限乘人数',
  `cllx` varchar(40) DEFAULT NULL COMMENT '车辆类型',
  `cpxh` varchar(60) DEFAULT NULL COMMENT '厂牌型号',
  `scqymc` varchar(240) DEFAULT NULL COMMENT '生产企业名称',
  `dz` varchar(80) DEFAULT NULL COMMENT '地址',
  `dh` varchar(40) DEFAULT NULL COMMENT '电话',
  `khyh` varchar(80) DEFAULT NULL COMMENT '开户银行',
  `zh` varchar(40) DEFAULT NULL COMMENT '账户',
  `swjgdm` varchar(180) DEFAULT NULL,
  `wspzh` varchar(40) DEFAULT NULL,
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  KEY `idx_motor` (`hid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='未开票机动车扩展';



# Dump of table einvoice_apply_ext
# ------------------------------------------------------------

DROP TABLE IF EXISTS `einvoice_apply_ext`;

CREATE TABLE `einvoice_apply_ext` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apply_id` int(11) NOT NULL COMMENT 'apply表主键id',
  `project_id` int(10) DEFAULT NULL COMMENT '项目id',
  `src_his_id` bigint(20) DEFAULT NULL COMMENT '发票来源id(发票重开原his表id)',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table einvoice_apply_merge
# ------------------------------------------------------------

DROP TABLE IF EXISTS `einvoice_apply_merge`;

CREATE TABLE `einvoice_apply_merge` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `original_fpqqlsh` varchar(20) NOT NULL COMMENT '原始流水号',
  `fpqqlsh` varchar(20) NOT NULL COMMENT '合并后流水号',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_original_lsh` (`original_fpqqlsh`) USING BTREE,
  KEY `idx_lsh` (`fpqqlsh`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='未开票合并信息';



# Dump of table einvoice_his_account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `einvoice_his_account`;

CREATE TABLE `einvoice_his_account` (
  `id` int(11) unsigned NOT NULL COMMENT '开票历史主表主键',
  `account_status` char(1) NOT NULL DEFAULT '1' COMMENT '1-未记账；2-已记账',
  `account_user` varchar(50) DEFAULT NULL,
  `account_date` datetime DEFAULT NULL COMMENT '记账时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开票历史主表扩展表';



# Dump of table einvoice_his_b_motor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `einvoice_his_b_motor`;

CREATE TABLE `einvoice_his_b_motor` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `hid` bigint(20) unsigned NOT NULL COMMENT '发票子表id',
  `sfzhm` varchar(22) DEFAULT NULL COMMENT '身份证号码/组织机构代码',
  `cd` varchar(80) DEFAULT NULL COMMENT '产地',
  `hgzh` varchar(100) DEFAULT NULL COMMENT '合格证号',
  `jkzmsh` varchar(80) DEFAULT NULL COMMENT '进口证明书号',
  `sjdh` varchar(80) DEFAULT NULL COMMENT '商检单号',
  `fdjhm` varchar(120) DEFAULT NULL COMMENT '发动机号码',
  `cjhm` varchar(40) DEFAULT NULL COMMENT '车架号码',
  `dunwei` varchar(40) DEFAULT NULL COMMENT '吨位',
  `xcrs` varchar(40) DEFAULT NULL COMMENT '限乘人数',
  `cllx` varchar(40) DEFAULT NULL COMMENT '车辆类型',
  `cpxh` varchar(60) DEFAULT NULL COMMENT '厂牌型号',
  `scqymc` varchar(240) DEFAULT NULL COMMENT '生产企业名称',
  `dz` varchar(80) DEFAULT NULL COMMENT '地址',
  `dh` varchar(40) DEFAULT NULL COMMENT '电话',
  `khyh` varchar(80) DEFAULT NULL COMMENT '开户银行',
  `zh` varchar(40) DEFAULT NULL COMMENT '账户',
  `swjgdm` varchar(180) DEFAULT NULL COMMENT '主管税务机关代码',
  `wspzh` varchar(40) DEFAULT NULL COMMENT '完税凭证号',
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  KEY `idx_motor` (`hid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='已开票机动车扩展';



# Dump of table einvoice_his_ext
# ------------------------------------------------------------

DROP TABLE IF EXISTS `einvoice_his_ext`;

CREATE TABLE `einvoice_his_ext` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `his_id` bigint(20) NOT NULL COMMENT 'his表主键id',
  `project_id` int(10) DEFAULT NULL COMMENT '项目id',
  `src_his_id` bigint(20) DEFAULT NULL COMMENT '发票来源id(发票重开原his表id)',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table einvoice_his_recent
# ------------------------------------------------------------

DROP TABLE IF EXISTS `einvoice_his_recent`;

CREATE TABLE `einvoice_his_recent` (
  `ID` bigint(20) unsigned NOT NULL,
  `FPQQLSH` varchar(64) NOT NULL COMMENT '发票请求流水号 ',
  `FPLX` varchar(4) DEFAULT NULL COMMENT '发票类型1增值税电子普通发票;3增值税普通发票;4增值税专用发票;8成品油电子发票;9成品油普通发票(卷式);10成品油普通发票;11成品油专用发票;12增值税普通发票(卷式)',
  `ZSFS` varchar(1) DEFAULT '0' COMMENT '征税方式 0-普通征税 2-差额征税',
  `KPLX` int(1) NOT NULL DEFAULT '0' COMMENT '开票类型 ',
  `FPJZ` char(1) DEFAULT '0' COMMENT '发票介质:0-电子发票;1-纸质发票。',
  `XSF_NSRSBH` char(20) DEFAULT NULL COMMENT '销售方纳税人识别号',
  `XSF_MC` varchar(100) DEFAULT NULL COMMENT '销售方名称',
  `XSF_DZDH` varchar(100) DEFAULT NULL COMMENT '销售方地址、电话',
  `XSF_YHZH` varchar(100) DEFAULT NULL COMMENT '销售方银行账号',
  `GMF_NSRSBH` char(20) DEFAULT NULL COMMENT '购买方纳税人识别号',
  `GMF_MC` varchar(100) DEFAULT NULL COMMENT '购买方名称',
  `GMF_DZDH` varchar(100) DEFAULT NULL COMMENT '购买方地址、电话',
  `GMF_YHZH` varchar(100) DEFAULT NULL COMMENT '购买方银行账号',
  `KPR` varchar(20) DEFAULT NULL COMMENT '开票人',
  `SKR` varchar(20) DEFAULT NULL COMMENT '收款人',
  `FHR` varchar(20) DEFAULT NULL COMMENT '复核人',
  `TSCHBZ` char(1) DEFAULT '0' COMMENT '特殊冲红标志',
  `YFP_DM` varchar(12) DEFAULT NULL COMMENT '原发票代码',
  `YFP_HM` varchar(8) DEFAULT NULL COMMENT '原发票号码',
  `JSHJ` decimal(15,2) DEFAULT NULL COMMENT '价税合计',
  `HJJE` decimal(15,2) DEFAULT NULL COMMENT '合计金额',
  `HJSE` decimal(15,2) DEFAULT NULL COMMENT '合计税额',
  `BZ` varchar(200) DEFAULT NULL COMMENT '备注',
  `JQBH` varchar(12) DEFAULT NULL COMMENT '税控设备编号',
  `FP_DM` varchar(12) DEFAULT NULL COMMENT '发票代码',
  `FP_HM` varchar(8) DEFAULT NULL COMMENT '发票号码',
  `KPRQ` varchar(14) DEFAULT NULL COMMENT '开票日期',
  `FP_MW` varchar(112) DEFAULT NULL COMMENT '发票密文',
  `JYM` char(20) DEFAULT NULL COMMENT '校验码',
  `EWM` varchar(3000) DEFAULT NULL COMMENT '二维码',
  `ZDRQ` date DEFAULT NULL COMMENT '制单日期',
  `SBBZ` varchar(512) DEFAULT NULL COMMENT '失败备注',
  `LYLX` char(1) DEFAULT NULL COMMENT '发票申请来源',
  `LYID` varchar(255) DEFAULT NULL COMMENT '发票申请来源id',
  `DEF1` varchar(255) DEFAULT NULL COMMENT '自定义项',
  `DEF2` varchar(255) DEFAULT NULL,
  `DEF3` varchar(255) DEFAULT NULL,
  `DEF4` varchar(255) DEFAULT NULL,
  `DEF5` varchar(255) DEFAULT NULL,
  `tenantid` varchar(64) DEFAULT NULL COMMENT '租户id',
  `creator` varchar(64) DEFAULT '~' COMMENT '创建者',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `status` char(1) DEFAULT NULL COMMENT '状态：1、已生成版式文件2、已下载3、已入帐',
  `bred` char(1) DEFAULT NULL COMMENT '是否被红冲',
  `corpId` varchar(64) NOT NULL COMMENT '企业（集团）编码',
  `orgId` int(10) unsigned NOT NULL COMMENT '组织编码',
  `BMB_BBH` varchar(20) DEFAULT '10.0',
  `SGBZ` varchar(1) DEFAULT NULL COMMENT '农产品收购标志；2=农产品收购',
  `zdybz` varchar(200) DEFAULT NULL COMMENT '自定义备注',
  `zfbz` char(1) DEFAULT 'N' COMMENT '作废标志；Y=已作废，N-未作废，I=正在作废，F=作废失败（失败原因在失败备注中）',
  `account_status` char(1) DEFAULT NULL COMMENT '1-未记账；2-已记账',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `hzxxbbh` varchar(30) DEFAULT NULL COMMENT '红字信息表编号',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `his_fpqqlsh` (`FPQQLSH`,`corpId`),
  KEY `idx_his_kprq` (`KPRQ`),
  KEY `his_yhmydm` (`YFP_HM`,`YFP_DM`),
  KEY `his_hmdm` (`FP_HM`,`FP_DM`),
  KEY `idx_orgid_rq` (`orgId`,`KPRQ`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table einvoice_his_recent_b
# ------------------------------------------------------------

DROP TABLE IF EXISTS `einvoice_his_recent_b`;

CREATE TABLE `einvoice_his_recent_b` (
  `ID` bigint(20) unsigned NOT NULL,
  `HID` bigint(20) unsigned DEFAULT NULL,
  `FPHXZ` int(11) DEFAULT NULL COMMENT '发票行性质',
  `XMMC` varchar(90) DEFAULT NULL COMMENT '项目名称',
  `DW` varchar(20) DEFAULT NULL COMMENT '计量单位',
  `GGXH` varchar(40) DEFAULT NULL COMMENT '规格型号',
  `XMSL` decimal(15,6) DEFAULT NULL COMMENT '项目数量',
  `XMDJ` decimal(20,10) DEFAULT NULL COMMENT '项目单价',
  `xmhsdj` decimal(20,10) DEFAULT NULL COMMENT '项目含税单价',
  `XMJE` decimal(15,2) DEFAULT NULL COMMENT '项目金额',
  `SL` decimal(6,6) DEFAULT NULL COMMENT '税率',
  `SE` decimal(15,2) DEFAULT NULL COMMENT '税额',
  `KCE` decimal(15,2) DEFAULT NULL COMMENT '扣除额',
  `HSBZ` varchar(1) DEFAULT NULL,
  `XMJSHJ` decimal(15,2) DEFAULT NULL COMMENT '项目价税合计',
  `HH` varchar(11) DEFAULT NULL COMMENT '行号',
  `ZKHHH` varchar(11) DEFAULT NULL COMMENT '折扣行行号',
  `SPBM` varchar(19) DEFAULT NULL,
  `ZXBM` varchar(20) DEFAULT '10',
  `YHZCBS` int(1) DEFAULT '0',
  `LSLBS` char(1) DEFAULT NULL,
  `ZZSTSGL` varchar(50) DEFAULT NULL,
  `ysxmmc` varchar(90) DEFAULT NULL COMMENT '原始项目名称（不带分类）',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`ID`),
  KEY `his_bid` (`HID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table einvoice_his_recent_b_motor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `einvoice_his_recent_b_motor`;

CREATE TABLE `einvoice_his_recent_b_motor` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `hid` bigint(20) unsigned NOT NULL COMMENT '发票子表id',
  `sfzhm` varchar(22) DEFAULT NULL COMMENT '身份证号码/组织机构代码',
  `cd` varchar(80) DEFAULT NULL COMMENT '产地',
  `hgzh` varchar(100) DEFAULT NULL COMMENT '合格证号',
  `jkzmsh` varchar(80) DEFAULT NULL COMMENT '进口证明书号',
  `sjdh` varchar(80) DEFAULT NULL COMMENT '商检单号',
  `fdjhm` varchar(120) DEFAULT NULL COMMENT '发动机号码',
  `cjhm` varchar(40) DEFAULT NULL COMMENT '车架号码',
  `dunwei` varchar(40) DEFAULT NULL COMMENT '吨位',
  `xcrs` varchar(40) DEFAULT NULL COMMENT '限乘人数',
  `cllx` varchar(40) DEFAULT NULL COMMENT '车辆类型',
  `cpxh` varchar(60) DEFAULT NULL COMMENT '厂牌型号',
  `scqymc` varchar(240) DEFAULT NULL COMMENT '生产企业名称',
  `dz` varchar(80) DEFAULT NULL COMMENT '地址',
  `dh` varchar(40) DEFAULT NULL COMMENT '电话',
  `khyh` varchar(80) DEFAULT NULL COMMENT '开户银行',
  `zh` varchar(40) DEFAULT NULL COMMENT '账户',
  `swjgdm` varchar(180) DEFAULT NULL,
  `wspzh` varchar(40) DEFAULT NULL,
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  KEY `idx_motor` (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='已开票机动车历史记录扩展';



# Dump of table invoice_pre_bill
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_pre_bill`;

CREATE TABLE `invoice_pre_bill` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `FPQQLSH` varchar(64) NOT NULL COMMENT '发票请求流水号 ',
  `vbillcode` varchar(30) DEFAULT NULL COMMENT '单据号',
  `FPLX` varchar(4) NOT NULL DEFAULT '0' COMMENT '发票类型1增值税电子普通发票;3增值税普通发票;4增值税专用发票;8成品油电子发票;9成品油普通发票(卷式);10成品油普通发票;11成品油专用发票;12增值税普通发票(卷式)',
  `ZSFS` varchar(1) DEFAULT '0' COMMENT '征税方式 0-普通征税 2-差额征税',
  `KPLX` int(1) NOT NULL DEFAULT '0' COMMENT '开票类型 ',
  `FPJZ` char(1) NOT NULL DEFAULT '0' COMMENT '发票介质:0-电子发票;1-纸质发票。',
  `XSF_NSRSBH` char(20) DEFAULT NULL COMMENT '销售方纳税人识别号',
  `XSF_MC` varchar(100) DEFAULT NULL COMMENT '销售方名称',
  `XSF_DZDH` varchar(100) DEFAULT NULL COMMENT '销售方地址、电话',
  `XSF_YHZH` varchar(100) DEFAULT NULL COMMENT '销售方银行账号',
  `GMF_NSRSBH` char(20) DEFAULT NULL COMMENT '购买方纳税人识别号',
  `GMF_MC` varchar(100) DEFAULT NULL COMMENT '购买方名称',
  `GMF_DZDH` varchar(100) DEFAULT NULL COMMENT '购买方地址、电话',
  `GMF_YHZH` varchar(100) DEFAULT NULL COMMENT '购买方银行账号',
  `KPR` varchar(20) DEFAULT NULL COMMENT '开票人',
  `SKR` varchar(20) DEFAULT NULL COMMENT '收款人',
  `FHR` varchar(20) DEFAULT NULL COMMENT '复核人',
  `TSCHBZ` char(1) DEFAULT NULL COMMENT '特殊冲红标志',
  `JSHJ` decimal(15,2) DEFAULT NULL COMMENT '价税合计',
  `HJJE` decimal(15,2) DEFAULT NULL COMMENT '合计金额',
  `HJSE` decimal(15,2) DEFAULT NULL COMMENT '合计税额',
  `BZ` varchar(200) DEFAULT NULL COMMENT '备注',
  `ZDRQ` date DEFAULT NULL COMMENT '制单日期',
  `LYLX` char(1) DEFAULT NULL COMMENT '发票申请来源',
  `LYID` varchar(255) DEFAULT NULL COMMENT '发票申请来源id',
  `DEF1` varchar(255) DEFAULT NULL COMMENT '自定义项',
  `DEF2` varchar(255) DEFAULT NULL,
  `DEF4` varchar(255) DEFAULT NULL,
  `DEF3` varchar(255) DEFAULT NULL,
  `DEF5` varchar(255) DEFAULT NULL,
  `corpId` varchar(64) DEFAULT NULL COMMENT '企业（集团）编码',
  `orgId` int(10) unsigned DEFAULT NULL COMMENT '组织编码',
  `creator` varchar(64) DEFAULT '~' COMMENT '创建者',
  `zdybz` varchar(200) DEFAULT NULL COMMENT '自定义备注',
  `BMB_BBH` varchar(20) DEFAULT '10.0',
  `SGBZ` varchar(1) DEFAULT NULL COMMENT '农产品收购标志；2=农产品收购',
  `email` varchar(100) DEFAULT NULL COMMENT '邮件交付信息',
  `sms` varchar(100) DEFAULT NULL COMMENT '手机号交付信息',
  `call_back_url` varchar(500) DEFAULT NULL COMMENT 'url回调地址',
  `dr` tinyint(4) DEFAULT '0' COMMENT '删除标记；1-已删除；0-未删除',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `option_status` int(1) DEFAULT '0' COMMENT '发票单操作类型:\r\n0=未经任何操作;\r\n1=进行过拆单；\r\n2=进行过发票单合并\r\n',
  `original_pre_code` varchar(3000) DEFAULT NULL COMMENT '原始发票单号,拆单或发票单合并后,该字段记录原发票单',
  `lc` int(11) DEFAULT NULL COMMENT '联次 2-二联 3-三联 5-五联',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `apply_fpqqlsh` (`FPQQLSH`,`corpId`),
  KEY `IDX_ZDRQ_ID` (`ZDRQ`,`ID`),
  KEY `idx_orgid` (`orgId`),
  KEY `idx_lyid` (`LYID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table invoice_pre_bill_b
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_pre_bill_b`;

CREATE TABLE `invoice_pre_bill_b` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `HID` int(11) DEFAULT NULL COMMENT '发票申请表头id',
  `XMMC` varchar(90) DEFAULT NULL COMMENT '项目名称',
  `DW` varchar(20) DEFAULT NULL COMMENT '计量单位',
  `GGXH` varchar(40) DEFAULT NULL COMMENT '规格型号',
  `XMSL` decimal(15,6) DEFAULT NULL COMMENT '项目数量',
  `XMDJ` decimal(20,10) DEFAULT NULL COMMENT '项目单价',
  `xmhsdj` decimal(20,10) DEFAULT NULL COMMENT '项目含税单价',
  `XMJE` decimal(15,2) DEFAULT NULL COMMENT '项目金额',
  `SL` decimal(6,6) DEFAULT NULL COMMENT '税率',
  `SE` decimal(15,2) DEFAULT NULL COMMENT '税额',
  `KCE` decimal(15,2) DEFAULT NULL COMMENT '扣除额',
  `HSBZ` varchar(1) DEFAULT NULL,
  `XMJSHJ` decimal(15,2) DEFAULT NULL COMMENT '项目价税合计',
  `SPBM` varchar(19) DEFAULT NULL COMMENT '商品税收分类编码',
  `ZXBM` varchar(20) DEFAULT '10',
  `XMBM` varchar(90) DEFAULT NULL COMMENT '项目编码',
  `YHZCBS` int(1) DEFAULT '0',
  `LSLBS` char(1) DEFAULT NULL,
  `ZZSTSGL` varchar(50) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `fphxz` int(1) DEFAULT '0' COMMENT '发票行性质 0-正常行1-折扣行2-被折扣行',
  `hh` varchar(60) DEFAULT NULL COMMENT '行号 有折扣时需要必输',
  `zkhhh` varchar(60) DEFAULT NULL COMMENT '折扣行行号 有折扣时需要必输',
  PRIMARY KEY (`ID`),
  KEY `apply_b_hid` (`HID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table org_default_material
# ------------------------------------------------------------

DROP TABLE IF EXISTS `org_default_material`;

CREATE TABLE `org_default_material` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `material_id` int(10) unsigned NOT NULL,
  `orgid` int(11) NOT NULL DEFAULT '0' COMMENT '组织id；0 为全局',
  `editable` char(1) NOT NULL COMMENT 'Y:可编辑;N:不可编辑',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_materialid` (`material_id`),
  KEY `idx_orgid` (`orgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织默认商品';



# Dump of table org_material_rel
# ------------------------------------------------------------

DROP TABLE IF EXISTS `org_material_rel`;

CREATE TABLE `org_material_rel` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `material_id` int(10) unsigned NOT NULL,
  `orgid` int(11) NOT NULL DEFAULT '0' COMMENT '组织id；0 为全局',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_materialid` (`material_id`),
  KEY `idx_orgid` (`orgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品组织分类关系';



# Dump of table printer_conf
# ------------------------------------------------------------

DROP TABLE IF EXISTS `printer_conf`;

CREATE TABLE `printer_conf` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) NOT NULL COMMENT '打印机名称',
  `desc` varchar(200) DEFAULT NULL COMMENT '描述',
  `left` decimal(10,0) NOT NULL,
  `top` decimal(10,0) NOT NULL,
  `version` varchar(20) NOT NULL COMMENT '版本',
  `enable` varchar(1) NOT NULL COMMENT 'Y—启用；N—不启用',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table redinfo_apply
# ------------------------------------------------------------

DROP TABLE IF EXISTS `redinfo_apply`;

CREATE TABLE `redinfo_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `req_bill_no` varchar(24) DEFAULT NULL COMMENT '信息表流水号',
  `red_apply_no` varchar(30) DEFAULT NULL COMMENT '红字申请单号',
  `res_bill_no` varchar(24) DEFAULT NULL COMMENT '信息表编号',
  `status_dm` char(1) DEFAULT NULL COMMENT '信息表状态代码（1：未上传，2：上传中，3：上传失败，4：上传成功）',
  `status_mc` varchar(200) DEFAULT NULL COMMENT '信息表状态描述',
  `req_memo` varchar(12) DEFAULT NULL COMMENT '申请选择（固定10位，购买方申请已抵扣：1100000000、购买方申请未抵扣：1010000000、销售方申请：0000000100）',
  `cpy_memo` char(1) DEFAULT NULL COMMENT '成品油（1：涉及销售数量变更，2：涉及销售金额变更）',
  `jqbh` varchar(12) DEFAULT NULL COMMENT '机器编号',
  `yfp_dm` varchar(12) DEFAULT NULL COMMENT '发票代码',
  `yfp_hm` varchar(8) DEFAULT NULL COMMENT '发票号码',
  `zdrq` date DEFAULT NULL COMMENT '制单日期',
  `gmf_mc` varchar(100) DEFAULT NULL COMMENT '购买方名称',
  `gmf_nsrsbh` char(20) DEFAULT NULL COMMENT '购买方税号',
  `gmf_dzdh` varchar(100) DEFAULT NULL COMMENT '购买方地址电话',
  `gmf_yhzh` varchar(100) DEFAULT NULL COMMENT '购买方银行账户',
  `xsf_mc` varchar(100) DEFAULT NULL COMMENT '销售方名称',
  `xsf_nsrsbh` char(20) DEFAULT NULL COMMENT '销售方税号',
  `hjje` decimal(15,2) DEFAULT NULL COMMENT '合计金额',
  `hjse` decimal(15,2) DEFAULT NULL COMMENT '合计税额',
  `jshj` decimal(15,2) DEFAULT NULL COMMENT '价税合计',
  `kpr` varchar(20) DEFAULT NULL COMMENT '开票人',
  `skr` varchar(20) DEFAULT NULL COMMENT '收款人',
  `fhr` varchar(20) DEFAULT NULL COMMENT '复核人',
  `bmb_bbh` varchar(20) DEFAULT NULL COMMENT '编码表版本号',
  `fplx` varchar(4) DEFAULT NULL COMMENT '发票类型',
  `lylx` char(1) DEFAULT NULL COMMENT '来源类型（1：平台）',
  `lyid` varchar(255) DEFAULT NULL COMMENT '来源id',
  `zdybz` varchar(200) DEFAULT NULL COMMENT '自定义备注',
  `userid` varchar(64) DEFAULT NULL COMMENT '经办人',
  `fpqqlsh` varchar(64) DEFAULT NULL COMMENT '红票发票请求流水号',
  `orgid` int(11) DEFAULT NULL,
  `corpid` varchar(64) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `source` char(1) DEFAULT NULL COMMENT '来源与接口还是PC端。1：来源于接口。',
  PRIMARY KEY (`id`),
  KEY `req_bill_no` (`req_bill_no`) USING BTREE,
  KEY `res_bill_no` (`res_bill_no`) USING BTREE,
  KEY `fpDm_fpHm` (`yfp_dm`,`yfp_hm`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;



# Dump of table redinfo_apply_b
# ------------------------------------------------------------

DROP TABLE IF EXISTS `redinfo_apply_b`;

CREATE TABLE `redinfo_apply_b` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hid` int(11) DEFAULT NULL,
  `fphxz` int(11) DEFAULT NULL,
  `hh` varchar(11) DEFAULT NULL,
  `zkhhh` varchar(11) DEFAULT NULL,
  `xmmc` varchar(90) DEFAULT NULL,
  `ysxmmc` varchar(90) DEFAULT NULL COMMENT '原始项目名称(未增加分类的商品名称)',
  `dw` varchar(20) DEFAULT NULL,
  `ggxh` varchar(40) DEFAULT NULL,
  `xmsl` decimal(15,6) DEFAULT NULL,
  `xmdj` decimal(20,10) DEFAULT NULL,
  `xmhsdj` decimal(20,10) DEFAULT NULL,
  `xmje` decimal(15,2) DEFAULT NULL,
  `sl` decimal(6,6) DEFAULT NULL,
  `se` decimal(15,2) DEFAULT NULL,
  `kce` decimal(15,2) DEFAULT NULL,
  `hsbz` varchar(1) DEFAULT NULL,
  `xmjshj` decimal(15,2) DEFAULT NULL,
  `spbm` varchar(19) DEFAULT NULL,
  `zxbm` varchar(20) DEFAULT NULL,
  `yhzcbs` int(1) DEFAULT NULL,
  `lslbs` char(1) DEFAULT NULL,
  `zzstsgl` varchar(50) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;



# Dump of table reserve
# ------------------------------------------------------------

DROP TABLE IF EXISTS `reserve`;

CREATE TABLE `reserve` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) unsigned DEFAULT NULL COMMENT '组织id',
  `revemail` varchar(100) DEFAULT NULL COMMENT '收票邮箱',
  `revphone` varchar(40) DEFAULT NULL COMMENT '受票手机',
  `username` varchar(20) DEFAULT NULL COMMENT '客户联系人名称',
  `gmf_mc` varchar(100) DEFAULT NULL COMMENT '购买方名称(tax_info_id为空此处才有值)',
  `gmf_nsrsbh` varchar(20) DEFAULT NULL COMMENT '购买方纳税人识别号',
  `address` varchar(80) DEFAULT NULL COMMENT '购买方地址',
  `phone` varchar(20) DEFAULT NULL COMMENT '购买方电话',
  `dzdh` varchar(100) DEFAULT NULL COMMENT '地址电话（address+phone）',
  `bankname` varchar(60) DEFAULT NULL COMMENT '购买方开户银行',
  `bankaccount` varchar(40) DEFAULT NULL COMMENT '购买方银行账号',
  `yhzh` varchar(100) DEFAULT NULL COMMENT '银行账户（bankname+bankaccount）',
  `md5` varchar(32) DEFAULT NULL COMMENT 'md5值',
  `type` tinyint(4) NOT NULL COMMENT '类型（按照使用场景划分；1=普通开票；0=预约开票）',
  `wxopenid` varchar(100) DEFAULT NULL COMMENT '微信openid',
  `wxformid` varchar(100) DEFAULT NULL COMMENT '微信小程序formid',
  `note_value` varchar(20) DEFAULT NULL COMMENT '序号（桌号、房间号）',
  `jshj` decimal(15,2) DEFAULT NULL COMMENT '可开票金额（明细的合计）',
  `zdybz` varchar(200) DEFAULT NULL COMMENT '自定义备注',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  KEY `idx_customer_phone` (`revphone`) USING BTREE COMMENT '受票手机',
  KEY `idx_cus_md5` (`md5`) USING BTREE,
  KEY `idx_corp_nsrsbh` (`corpid`,`gmf_nsrsbh`) USING BTREE,
  KEY `idx_cus_gmfmc` (`gmf_mc`(20)) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约客户档案信息';

/* todo 删除没用的表 */
drop table client_info;
drop table customs_book;
drop table customs_book_b;
drop table deductible_type;
drop table einvoice_listener;
drop table einvoice_reservation;
drop table einvoice_smsaccount;
drop table ent_menu;
drop table ent_menu_rel;
drop table ent_menu_role;
drop table ent_role;
drop table ent_user_role;
drop table invoice_billing;
drop table invoice_collection;
drop table invoice_deduct_log;
drop table invoice_deductible;
drop table invoice_lsb_copy1;
drop table ocr_log;
drop table org_tax_equipment;
drop table orgnization;
drop table out_detail;
drop table out_gather;
drop table pub_message;
drop table pub_tax_info;
drop table reimburse_collection;
drop table sms_template;
drop table suspect_invoice;
drop table suspect_invoice_detail;
drop table suspect_invoice_motor;
drop table suspect_mgmt;
drop table sysparam;
drop table tax_body;
drop table tax_equipment_extend;
drop table tax_mech;
drop table tax_mech_inventory;
drop table tax_mech_sync_log;
drop table tmp_pub_taxclass;
drop table user_org;
drop table verify_history;

/*接下来处理yt_piaoeda_piaoeda */
use yt_piaoeda_piaoeda;
/* 修改已存在的表格 */
/* invoice */
alter table invoice add column `ZFRQ` datetime DEFAULT NULL COMMENT '作废日期';
alter table invoice modify column `BZ` varchar(256) DEFAULT NULL COMMENT '备注';
/* invoice_detail*/
alter table invoice_detail add column `YHZCBS` int(1) DEFAULT '0' COMMENT '优惠政策标识';
alter table invoice_detail add column `ZZSTSGL` varchar(50) DEFAULT NULL COMMENT '增值税特殊管理';
/* invoice_detail_motor */
alter table invoice_detail_motor add column `cllx` varchar(40) DEFAULT NULL COMMENT '车辆类型';
alter table invoice_detail_motor add column `cpxh` varchar(60) DEFAULT NULL COMMENT '厂牌型号';
alter table invoice_detail_motor add column `scqymc` varchar(240) DEFAULT NULL COMMENT '生产企业名称';
alter table invoice_detail_motor add column `sfzhm` varchar(22) DEFAULT NULL COMMENT '身份证号码/组织机构代码';
alter table invoice_detail_motor add column `dz` varchar(80) DEFAULT NULL COMMENT '地址';
alter table invoice_detail_motor add column `dh` varchar(40) DEFAULT NULL COMMENT '电话';
alter table invoice_detail_motor add column `khyh` varchar(80) DEFAULT NULL COMMENT '开户银行';
alter table invoice_detail_motor add column `zh` varchar(40) DEFAULT NULL COMMENT '账户';
/* invoice_ext*/
alter table invoice_ext add column `selfcheckstatus` int(11) DEFAULT NULL COMMENT '自检状态';
/* invoice_mobi_msg*/
alter table invoice_mobi_msg add column `bill_type` varchar(10) DEFAULT NULL;
/* mobile_msg */
alter table mobile_msg add column `bill_type` varchar(10) DEFAULT NULL;
/* wallet_c */
alter table wallet_c add column `tmp_userid` varbinary(64) DEFAULT NULL COMMENT '用户ID';
/* wallet_invoice_tag */
alter table wallet_invoice_tag add column `summary_id` bigint(20) DEFAULT NULL;
alter table wallet_invoice_tag add KEY `idx_wallet_tag` (`summary_id`) USING BTREE;
/* 个人票夹库新加的表 */
DROP TABLE IF EXISTS `bd_todo`;

CREATE TABLE `bd_todo` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(64) NOT NULL,
  `title` varchar(100) NOT NULL COMMENT '事项描述',
  `type` char(2) NOT NULL COMMENT '消息类型',
  `url` varchar(100) DEFAULT NULL,
  `bread` char(1) NOT NULL DEFAULT 'N' COMMENT '是否已读，Y-已读；N-未读',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='个人待办事项';



# Dump of table bd_user_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bd_user_info`;

CREATE TABLE `bd_user_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(64) NOT NULL COMMENT '用户id',
  `corpid` varchar(64) DEFAULT NULL,
  `orgid` int(11) DEFAULT NULL,
  `header_filepath` varchar(80) DEFAULT NULL,
  `name` varchar(40) NOT NULL COMMENT '个人姓名',
  `sex` char(1) NOT NULL COMMENT '性别；1-男；2-女',
  `mobile` varchar(11) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL COMMENT '国籍',
  `dept` varchar(40) DEFAULT NULL COMMENT '部门',
  `corpname` varchar(30) DEFAULT NULL COMMENT '公司名称',
  `employee_id` varchar(40) DEFAULT NULL COMMENT '员工编号',
  `contact` varchar(50) DEFAULT NULL COMMENT '联系地址',
  `identity_type` varchar(2) NOT NULL DEFAULT '1' COMMENT '证件类型；1.居民身份证、2.军官证、3.士兵证、4.武警警官证、5.港澳居民来往内地通行证、6.台湾居民来往大陆通行证、7.中华人民共和国港澳居民居住证、8.中华人民共和国台湾居民居住证、9.中国护照、10.外国护照、11.香港永久性居民身份证、12.台湾身份证、13.澳门特别行政区永久性居民身份证、14.外国人永久居留身份证',
  `identity_number` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `identity_number_ocr` varchar(18) DEFAULT NULL COMMENT '个人身份证_ocr',
  `identity_number_imp` varchar(18) DEFAULT NULL COMMENT '个人身份证_导入',
  `identity_front` varchar(80) DEFAULT NULL COMMENT '正面附件路径',
  `identity_back` varchar(80) DEFAULT NULL COMMENT '背面附件路径',
  `marital_status` char(1) DEFAULT NULL COMMENT '婚姻状况0未婚,1已婚',
  `spouse_name` varchar(20) DEFAULT NULL COMMENT '配偶姓名',
  `spouse_id_type` varchar(2) DEFAULT NULL,
  `spouse_id_number` varchar(18) DEFAULT NULL COMMENT '配偶身份证号',
  `spouse_id_front` varchar(80) DEFAULT NULL COMMENT '配偶身份证正面',
  `spouse_id_back` varchar(80) DEFAULT NULL COMMENT '配偶身份证背面',
  `approve_status` char(1) DEFAULT NULL COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL COMMENT '审核通过时间',
  `cee_approve_status` char(1) DEFAULT NULL,
  `edu_approve_status` char(1) DEFAULT NULL,
  `loan_approve_status` char(1) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `submittime` datetime DEFAULT NULL,
  `rent_approve_status` char(1) DEFAULT NULL,
  `elderly_approve_status` char(1) DEFAULT NULL,
  `ins_approve_status` char(1) DEFAULT NULL,
  `martyr_approve_status` char(1) DEFAULT NULL,
  `dis_approve_status` char(1) DEFAULT NULL,
  `disclaimer` char(1) DEFAULT NULL,
  `disclaimer_time` datetime DEFAULT NULL,
  `departure_date` date DEFAULT NULL,
  `employ_date` date DEFAULT NULL,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_orgid` (`orgid`),
  KEY `idx_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='个人基本信息';



# Dump of table invoice_air
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_air`;

CREATE TABLE `invoice_air` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` datetime DEFAULT NULL COMMENT '填开日期',
  `ticket_num` char(15) NOT NULL COMMENT '电子客票号码',
  `check_code` varchar(20) DEFAULT NULL COMMENT '验证码',
  `agent_code` varchar(40) DEFAULT NULL COMMENT '销售单位代号',
  `issue_by` varchar(60) DEFAULT NULL COMMENT '填开单位',
  `fare` decimal(15,2) DEFAULT NULL COMMENT '票价',
  `tax` decimal(15,2) DEFAULT NULL COMMENT '其它税费',
  `fuel_surcharge` decimal(15,2) DEFAULT NULL COMMENT '燃油附加费',
  `caac_develop_fund` decimal(15,2) DEFAULT NULL COMMENT '民航发展基金',
  `insurance` decimal(15,2) DEFAULT NULL COMMENT '保险费',
  `total_amount` decimal(15,2) NOT NULL COMMENT '总金额',
  `user_name` varchar(60) DEFAULT NULL COMMENT '乘机人姓名',
  `user_id` char(20) DEFAULT NULL COMMENT '身份证号',
  `purchaser_status` tinyint(1) DEFAULT '0' COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `fee_without_tax` decimal(15,2) DEFAULT NULL COMMENT '金额（不含税）',
  `tax_amount` decimal(15,2) DEFAULT NULL COMMENT '税额',
  `file_path` varchar(60) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm` (`ticket_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='航空电子行程单';



# Dump of table invoice_air_b
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_air_b`;

CREATE TABLE `invoice_air_b` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `air_id` bigint(20) NOT NULL COMMENT '航空行程单主表主键',
  `from` varchar(60) DEFAULT NULL COMMENT '出发',
  `to` varchar(60) DEFAULT NULL COMMENT '到达',
  `flight_number` varchar(40) DEFAULT NULL COMMENT '航班号',
  `carrier` varchar(20) DEFAULT NULL COMMENT '承运人',
  `seat` varchar(40) DEFAULT NULL COMMENT '舱位',
  `date` datetime DEFAULT NULL COMMENT '乘机日期',
  `time` varchar(20) DEFAULT NULL COMMENT '乘机时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='航空电子行程单明细';



# Dump of table invoice_machine
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_machine`;

CREATE TABLE `invoice_machine` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` datetime DEFAULT NULL COMMENT '开票日期',
  `time` varchar(20) DEFAULT NULL COMMENT '开票时间',
  `invoice_code` varchar(12) NOT NULL COMMENT '发票代码',
  `invoice_num` varchar(8) NOT NULL COMMENT '发票号码',
  `check_code` varchar(20) DEFAULT NULL COMMENT '校验码',
  `category` varchar(20) DEFAULT NULL COMMENT '种类，oil 表示是加油票',
  `total_amount` decimal(15,2) NOT NULL COMMENT '合计金额',
  `seller_name` varchar(40) DEFAULT NULL COMMENT '销售方名称',
  `seller_tax_id` char(20) DEFAULT NULL COMMENT '销售方纳税人识别号',
  `buyer_name` varchar(40) DEFAULT NULL COMMENT '购买方名称',
  `buyer_tax_id` char(20) DEFAULT NULL COMMENT '购买方纳税人识别号',
  `purchaser_status` tinyint(1) DEFAULT NULL COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `file_path` varchar(60) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`invoice_num`,`invoice_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机打发票';



# Dump of table invoice_machine_b
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_machine_b`;

CREATE TABLE `invoice_machine_b` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `machine_id` bigint(20) DEFAULT NULL COMMENT '机打发票主表主键',
  `item` varchar(20) DEFAULT NULL COMMENT '项目',
  `amount` decimal(15,2) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机打发票明细';



# Dump of table invoice_other
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_other`;

CREATE TABLE `invoice_other` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `invoice_code` varchar(32) DEFAULT NULL COMMENT '发票代码',
  `invoice_num` varchar(32) NOT NULL COMMENT '发票号码',
  `date` timestamp NULL DEFAULT NULL COMMENT '日期',
  `total_amount` decimal(15,2) DEFAULT '0.00' COMMENT '票面金额',
  `purchaser_status` tinyint(1) DEFAULT '-1' COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `file_path` varchar(60) DEFAULT NULL COMMENT '发票文件地址',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_hm` (`invoice_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='其他票种';



# Dump of table invoice_passenger
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_passenger`;

CREATE TABLE `invoice_passenger` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invoice_code` varchar(12) DEFAULT NULL COMMENT '发票代码',
  `invoice_num` varchar(16) DEFAULT NULL COMMENT '发票号码',
  `date` datetime DEFAULT NULL COMMENT '日期',
  `time` varchar(20) DEFAULT NULL COMMENT '时间',
  `entrance` varchar(60) DEFAULT NULL COMMENT '入口',
  `exit` varchar(60) DEFAULT NULL COMMENT '出口',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `total_amount` decimal(15,2) NOT NULL COMMENT '金额',
  `purchaser_status` tinyint(1) DEFAULT NULL COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `fee_without_tax` decimal(15,2) DEFAULT NULL COMMENT '合计金额（不含税）',
  `tax_amount` decimal(15,2) DEFAULT NULL COMMENT '税额',
  `file_path` varchar(60) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`invoice_num`,`invoice_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客运汽车票';



# Dump of table invoice_quota
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_quota`;

CREATE TABLE `invoice_quota` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invoice_code` varchar(12) NOT NULL COMMENT '发票代码',
  `invoice_num` varchar(8) NOT NULL COMMENT '发票号码',
  `total_amount` decimal(15,2) NOT NULL COMMENT '金额',
  `purchaser_status` tinyint(1) DEFAULT NULL COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `file_path` varchar(60) DEFAULT NULL,
  `product_name` varchar(20) DEFAULT NULL COMMENT '商品项目',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`invoice_num`,`invoice_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定额发票';



# Dump of table invoice_summary
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_summary`;

CREATE TABLE `invoice_summary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bill_id` bigint(20) DEFAULT NULL COMMENT '票据主键',
  `invoice_type` tinyint(1) DEFAULT NULL COMMENT '发票类型（1-增值税发票、卷票，2-出租车票，3-火车票，4-机打发票，5-定额发票，6- 过路费，7- 客运汽车票，8-航空电子行程单）',
  `invoice_medium` tinyint(1) DEFAULT NULL COMMENT '发票介质（0-电子发票，1-纸质发票）',
  `invoice_code` varchar(32) DEFAULT NULL COMMENT '发票代码',
  `invoice_num` varchar(32) DEFAULT NULL COMMENT '发票号码',
  `user_id` varchar(64) NOT NULL COMMENT '用户id',
  `date` datetime DEFAULT NULL COMMENT '日期',
  `time` varchar(20) DEFAULT NULL COMMENT '时间',
  `amount` decimal(15,2) DEFAULT NULL COMMENT '金额',
  `purchaser_status` tinyint(1) DEFAULT NULL COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `inspect_status` tinyint(1) DEFAULT NULL COMMENT '查验状态。（0：未查验。1：已查验。2：查验失败）',
  `buyer_name` varchar(100) DEFAULT NULL COMMENT '购买方名称',
  `seller_name` varchar(100) DEFAULT NULL COMMENT '销售方名称',
  `car_num` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `train_num` varchar(10) DEFAULT NULL COMMENT '火车车次',
  `origin` varchar(60) DEFAULT NULL COMMENT '始发站',
  `destination` varchar(60) DEFAULT NULL COMMENT '终点站',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `def1` varchar(20) DEFAULT NULL COMMENT '自定义项1',
  `def2` varchar(20) DEFAULT NULL COMMENT '自定义项2',
  `def3` varchar(20) DEFAULT NULL COMMENT '自定义项3',
  `def4` varchar(20) DEFAULT NULL COMMENT '自定义项4',
  `def5` varchar(20) DEFAULT NULL COMMENT '自定义项5',
  `def6` varchar(20) DEFAULT NULL COMMENT '自定义项6',
  `def7` varchar(20) DEFAULT NULL COMMENT '自定义项7',
  `def8` varchar(20) DEFAULT NULL COMMENT '自定义项8',
  `def9` varchar(20) DEFAULT NULL COMMENT '自定义项9',
  `def10` varchar(20) DEFAULT NULL COMMENT '自定义项10',
  `wallet_id` int(11) DEFAULT NULL COMMENT '从wallet_c表导入的数据id',
  `file_path` varchar(60) DEFAULT NULL,
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `vat_type` varchar(4) DEFAULT NULL COMMENT '增值税发票类型1增值税电子普通发票;3增值税普通发票;4增值税专用发票;5机动车销售统一发票;6货物运输业增值税专用发票;14通行费发票;8成品油电子发票',
  `itinerary_path` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_summary_userid` (`user_id`) USING BTREE,
  KEY `idx_summary_billid` (`bill_id`) USING BTREE,
  KEY `idx_summary_hm` (`invoice_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='票据摘要';



# Dump of table invoice_taxi
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_taxi`;

CREATE TABLE `invoice_taxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` datetime DEFAULT NULL COMMENT '开票日期',
  `invoice_code` varchar(12) DEFAULT NULL COMMENT '发票代码',
  `invoice_num` varchar(8) DEFAULT NULL COMMENT '发票号码',
  `car_num` varchar(20) DEFAULT NULL COMMENT '车牌号',
  `mileage` decimal(15,2) DEFAULT NULL COMMENT '里程',
  `start_time` varchar(20) DEFAULT NULL COMMENT '上车时间',
  `end_time` varchar(20) DEFAULT NULL COMMENT '下车时间',
  `total_amount` decimal(15,2) NOT NULL COMMENT '金额',
  `purchaser_status` tinyint(1) DEFAULT NULL COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `place` varchar(20) DEFAULT NULL COMMENT '发票所在地',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `file_path` varchar(60) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`invoice_num`,`invoice_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出租车票';



# Dump of table invoice_tolls
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_tolls`;

CREATE TABLE `invoice_tolls` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `invoice_code` varchar(12) NOT NULL COMMENT '发票代码',
  `invoice_num` varchar(20) NOT NULL COMMENT '发票号码',
  `date` datetime DEFAULT NULL COMMENT '日期',
  `time` varchar(20) DEFAULT NULL COMMENT '时间',
  `entrance` varchar(30) DEFAULT NULL COMMENT '入口',
  `exit` varchar(30) DEFAULT NULL COMMENT '出口',
  `total_amount` decimal(15,2) NOT NULL COMMENT '金额',
  `purchaser_status` tinyint(1) DEFAULT NULL COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `file_path` varchar(60) DEFAULT NULL COMMENT '文件路径',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_hm_dm` (`invoice_num`,`invoice_code`) USING BTREE COMMENT '发票代码、号码唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='过路费';



# Dump of table invoice_train
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice_train`;

CREATE TABLE `invoice_train` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `number` varchar(32) DEFAULT NULL COMMENT '号码（火车票唯一性）',
  `ticket_num` varchar(12) DEFAULT NULL COMMENT '火车票号',
  `date` datetime NOT NULL COMMENT '日期',
  `time` varchar(20) DEFAULT NULL COMMENT '时间',
  `train_num` varchar(10) DEFAULT NULL COMMENT '车次',
  `origin` varchar(20) DEFAULT NULL COMMENT '始发站',
  `destination` varchar(20) DEFAULT NULL COMMENT '终点站',
  `level` varchar(10) DEFAULT NULL COMMENT '坐席',
  `seat_no` varchar(20) DEFAULT NULL COMMENT '座位号',
  `name` varchar(20) DEFAULT '' COMMENT '姓名',
  `total_amount` decimal(15,2) NOT NULL COMMENT '金额',
  `fee_without_tax` decimal(15,2) DEFAULT NULL COMMENT '金额（不含税）',
  `tax_amount` decimal(15,2) DEFAULT NULL COMMENT '税额',
  `purchaser_status` tinyint(1) DEFAULT NULL COMMENT '报销状态（-1-未设值;30-未收票;33-待提交;34-已归集;35-未报销;36-报销中;37-未记账;39-已报销;42-已记账;）',
  `kind` varchar(20) DEFAULT NULL COMMENT '发票消费类型',
  `file_path` varchar(60) DEFAULT NULL COMMENT '文件路径',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='火车票';



# Dump of table ocr_airport
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ocr_airport`;

CREATE TABLE `ocr_airport` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `airport_code` char(3) NOT NULL DEFAULT '' COMMENT '机场三字码',
  `airport_name` varchar(16) NOT NULL DEFAULT '' COMMENT '机场名称',
  `city_code` char(3) NOT NULL DEFAULT '' COMMENT '城市代码',
  `city_name` varchar(16) NOT NULL DEFAULT '' COMMENT '城市名称',
  `province` varchar(16) NOT NULL DEFAULT '' COMMENT '省名称',
  `keyword` varchar(50) NOT NULL DEFAULT '' COMMENT '关键字',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ocr机场表';



# Dump of table ocr_file_rel
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ocr_file_rel`;

CREATE TABLE `ocr_file_rel` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `file_path` varchar(60) NOT NULL COMMENT '文件路径',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ocr文件路径（私有部署使用，公有云不用）';



# Dump of table pit_cee
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_cee`;

CREATE TABLE `pit_cee` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(64) NOT NULL COMMENT '用户id',
  `edu_stage` char(1) DEFAULT NULL COMMENT '学历教育姓名',
  `edu_start` date DEFAULT NULL COMMENT '学习起始日期',
  `edu_end` date DEFAULT NULL COMMENT '预计结束日期',
  `student_filepath` varchar(80) DEFAULT NULL COMMENT '学籍证明',
  `edu_type` char(1) DEFAULT NULL COMMENT '教育类型，1-成人高等教育；2-高等教育自学考试；3-电大现代远程开放教育和网络大学',
  `vocational_date` date DEFAULT NULL COMMENT '职业资格-发证日期',
  `vocational_cert_name` varchar(30) DEFAULT NULL COMMENT '职业资格-证书名称',
  `vocational_number` varchar(40) DEFAULT NULL COMMENT '职业资格-证书编号',
  `vocational_org` varchar(30) DEFAULT NULL COMMENT '职业资格-发证机构',
  `vocational_filepath` varchar(80) DEFAULT NULL COMMENT '职业资格证书附件',
  `approve_status` char(1) DEFAULT '1' COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL COMMENT '审核通过时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='继续教育专项附加扣除';



# Dump of table pit_children_edu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_children_edu`;

CREATE TABLE `pit_children_edu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(64) NOT NULL COMMENT '用户id',
  `name` varchar(20) NOT NULL COMMENT '子女姓名',
  `identity_type` varchar(2) DEFAULT NULL COMMENT '证件类型',
  `identity_number` varchar(18) DEFAULT NULL COMMENT '证件',
  `birthday` date NOT NULL COMMENT '出生日期',
  `current_edu` char(2) DEFAULT '0' COMMENT '教育阶段，0-无；1-学前教育；2-小学；3-初中教育；4-普通高中；5-中等职业教育；6-大学专科；7-大学本科；8-硕士研究生；9-博士研究生教育',
  `school` varchar(100) DEFAULT NULL COMMENT '就读学校',
  `country` varchar(30) DEFAULT NULL COMMENT '就读国家',
  `student_number` varchar(20) DEFAULT NULL COMMENT '学籍号',
  `deduction_method` char(1) DEFAULT '1' COMMENT '扣除方式，1-由本人扣除；2-由配偶扣除；3-按50%分别扣除',
  `edu_start` date DEFAULT NULL COMMENT '学习起始日期',
  `edu_end` date DEFAULT NULL COMMENT '学习结束日期',
  `edu_Final` date DEFAULT NULL COMMENT '教育终止日期',
  `household_master` varchar(80) DEFAULT NULL COMMENT '户口主页',
  `household_sub` varchar(80) DEFAULT NULL COMMENT '户口附页',
  `student_certificate` varchar(80) DEFAULT NULL COMMENT '学籍证明附件',
  `approve_status` char(1) DEFAULT '1' COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL,
  `nationality` varchar(30) DEFAULT NULL COMMENT '国籍',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='子女教育专项附加扣除';



# Dump of table pit_deduction
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_deduction`;

CREATE TABLE `pit_deduction` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `corpid` varchar(64) DEFAULT NULL,
  `orgid` int(11) DEFAULT NULL,
  `userid` varchar(64) NOT NULL,
  `total_cee` decimal(15,2) DEFAULT NULL COMMENT '累计学历学位继续教育',
  `total_vocation_cee` decimal(15,2) DEFAULT NULL COMMENT '累计职业资格继续教育',
  `total_child_edu` decimal(15,2) DEFAULT NULL COMMENT '累计子女教育',
  `child_num` int(11) DEFAULT NULL,
  `total_housing_loan` decimal(15,2) DEFAULT NULL COMMENT '累计住房贷款',
  `total_housing_rent` decimal(15,2) DEFAULT NULL COMMENT '累计住房租金',
  `total_elderly` decimal(15,2) DEFAULT NULL COMMENT '累计赡养老人',
  `declare_period` varchar(20) DEFAULT NULL COMMENT '申报期',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工扣除信息';



# Dump of table pit_disability
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_disability`;

CREATE TABLE `pit_disability` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(64) NOT NULL,
  `disability_type` char(1) DEFAULT NULL COMMENT '残疾类型',
  `disability_card_no` varchar(20) DEFAULT NULL COMMENT '残疾人证号',
  `disability_card_date` date DEFAULT NULL COMMENT '残疾证发起日期',
  `approve_status` char(1) DEFAULT '1' COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `disability_filepath` varchar(80) DEFAULT NULL COMMENT '残疾人证件附件',
  PRIMARY KEY (`id`),
  KEY `idx_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='残疾人相关\n';



# Dump of table pit_elderly
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_elderly`;

CREATE TABLE `pit_elderly` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(64) NOT NULL COMMENT '用户id',
  `onlychild` char(1) DEFAULT NULL COMMENT '是否独生子女 1：是 2：否',
  `apport_type` varchar(20) DEFAULT NULL COMMENT '分摊方式',
  `deduct_amount` decimal(10,0) DEFAULT NULL COMMENT '扣除方式',
  `approve_status` char(1) DEFAULT NULL,
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='赡养老人专项附加扣除';



# Dump of table pit_elderly_common
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_elderly_common`;

CREATE TABLE `pit_elderly_common` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL,
  `userid` varchar(64) NOT NULL COMMENT '用户id',
  `common_id_type` varchar(2) DEFAULT NULL COMMENT '身份证件类型',
  `common_id_number` varchar(18) DEFAULT NULL COMMENT '身份证件号码',
  `common_name` varchar(20) DEFAULT NULL,
  `common_country` varchar(50) DEFAULT NULL COMMENT '地址',
  `common_front_filepath` varchar(80) DEFAULT NULL COMMENT '身份证正面',
  `common_back_filepath` varchar(80) DEFAULT NULL COMMENT '身份证反面',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_hid` (`hid`),
  KEY `idx_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='共同赡养老人';



# Dump of table pit_elderly_dep
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_elderly_dep`;

CREATE TABLE `pit_elderly_dep` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hid` int(11) NOT NULL,
  `userid` varchar(64) NOT NULL COMMENT '用户id',
  `name` varchar(20) NOT NULL COMMENT '第一位赡养人姓名',
  `relationship` char(1) DEFAULT NULL COMMENT '第一位与扣除人关系，1-父亲；2-母亲；3-祖父母；4-外祖父母',
  `id_type` varchar(2) DEFAULT NULL COMMENT '第一位身份证类型',
  `id_number` varchar(18) DEFAULT NULL COMMENT '第一位身份证号',
  `country` varchar(50) DEFAULT NULL COMMENT '第一位地址',
  `birth` date DEFAULT NULL COMMENT '第一位出生日期',
  `id_front_filepath` varchar(80) DEFAULT NULL COMMENT '第一位身份证正面',
  `id_back_filepath` varchar(80) DEFAULT NULL COMMENT '第一位身份证反面',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_hid` (`hid`),
  KEY `idx_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='被赡养人';



# Dump of table pit_housing_loan
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_housing_loan`;

CREATE TABLE `pit_housing_loan` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(64) NOT NULL COMMENT '用户id',
  `house_type` char(1) DEFAULT NULL COMMENT '房屋类型',
  `house_contract_num` varchar(40) DEFAULT NULL COMMENT '新增-产权证号/不动产登记号/商品房买卖合同号',
  `own` char(1) DEFAULT NULL COMMENT '本人是否借款人  Y：是 N：否',
  `first_house_loan` char(1) DEFAULT NULL COMMENT '是否婚前各自首套贷款  Y：是 N：否',
  `house_address` varchar(50) DEFAULT NULL COMMENT '住房地址',
  `loan_type` char(1) DEFAULT NULL COMMENT '贷款方式，1-商业代码；2-公积金贷款；3-组合贷款',
  `loan_bank` varchar(30) DEFAULT NULL COMMENT '贷款银行',
  `pf_loan_contract_num` varchar(40) DEFAULT NULL COMMENT '公积金贷款合同编号',
  `pf_loan_amont` decimal(10,2) DEFAULT NULL COMMENT '公积金贷款金额',
  `loan_month` smallint(1) unsigned DEFAULT NULL COMMENT '公积金期限',
  `repayment_date` date DEFAULT NULL COMMENT '公积金还款日期',
  `business_loan_contract_num` varchar(40) DEFAULT NULL COMMENT '商业贷款合同编号',
  `business_loan_amont` decimal(10,0) DEFAULT NULL COMMENT '商业贷款金额',
  `loan_frontpath` varchar(80) DEFAULT NULL COMMENT '贷款封面路径',
  `loan_filepath` varchar(80) DEFAULT NULL COMMENT '合同附件',
  `approve_status` char(1) DEFAULT '1' COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='申报住房贷款信息专项附件扣除';



# Dump of table pit_housing_rent
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_housing_rent`;

CREATE TABLE `pit_housing_rent` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(64) NOT NULL COMMENT '用户id',
  `name` varchar(20) NOT NULL COMMENT '租房人姓名',
  `area` varchar(20) DEFAULT NULL COMMENT '租住所在省、市、区',
  `address` varchar(50) DEFAULT NULL COMMENT '详细地址',
  `province` varchar(20) DEFAULT NULL COMMENT '省份',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  `type` char(1) DEFAULT NULL COMMENT '类型：个人或组织',
  `identity_type` varchar(2) DEFAULT NULL COMMENT '身份证件类型',
  `identity_number` varchar(18) DEFAULT NULL COMMENT '身份证件号码',
  `contract_number` varchar(30) DEFAULT NULL COMMENT '合同编号',
  `rent_start` date DEFAULT NULL COMMENT '租定起始日期',
  `rent_end` date DEFAULT NULL COMMENT '预计结束日期',
  `rent_filepath` varchar(80) DEFAULT NULL COMMENT '合同附件',
  `rent_second_filepath` varchar(80) DEFAULT NULL,
  `approve_status` char(1) DEFAULT '1' COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='住房租金专项附加扣除';



# Dump of table pit_insurance
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_insurance`;

CREATE TABLE `pit_insurance` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(64) NOT NULL,
  `policy_holder_name` varchar(20) DEFAULT NULL COMMENT '投保人姓名',
  `insurance_company` varchar(20) DEFAULT NULL COMMENT '保险公司名称',
  `insurance_contract_no` varchar(20) DEFAULT NULL COMMENT '保险合同号',
  `insurance_contract_start` date DEFAULT NULL COMMENT '保险合同起始',
  `insurance_contract_end` date DEFAULT NULL COMMENT '保险合同截止',
  `approve_status` char(1) DEFAULT '1' COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `reason` varchar(300) DEFAULT NULL,
  `insurance_filepath` varchar(80) DEFAULT NULL COMMENT '保险合同附件',
  `annual_premium` decimal(15,2) DEFAULT NULL COMMENT '年度保费',
  `monthly_premium` decimal(15,2) DEFAULT NULL COMMENT '月度保费',
  `tax_preference_identification_code` varchar(20) DEFAULT NULL COMMENT '税优识别码',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商业健康保险';



# Dump of table pit_martyr
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pit_martyr`;

CREATE TABLE `pit_martyr` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userid` varchar(64) NOT NULL,
  `martyr_name` varchar(20) DEFAULT NULL COMMENT '烈士姓名',
  `martyr_relation` char(1) DEFAULT NULL COMMENT '烈士与扣除人关系，1-父母；2-抚养人；3-配偶；4-子女；5-兄弟姐妹',
  `martyr_filepath` varchar(80) DEFAULT NULL,
  `approve_status` char(1) DEFAULT '1' COMMENT '审核状态，1-未提交；2-已提交；3-审核通过；4-审核不通过',
  `reason` varchar(300) DEFAULT NULL,
  `pass_date` datetime DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `ts` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='烈属相关';

/*个人票夹需要执行的个人票夹升级脚本*/
-- 执行更新（更新个人用户code）
update wallet_c, yt_piaoeda_einvoice_auth.einvoice_user
set wallet_c.tmp_userid = yt_piaoeda_einvoice_auth.einvoice_user.userid
where wallet_c.USERC_ID = yt_piaoeda_einvoice_auth.einvoice_user.usercode
and yt_piaoeda_einvoice_auth.einvoice_user.usertype in (1,4)
;
-- 更新只有企业用户没有个人用户的
update wallet_c, yt_piaoeda_einvoice_auth.einvoice_user
set wallet_c.tmp_userid = yt_piaoeda_einvoice_auth.einvoice_user.userid
where wallet_c.USERC_ID = yt_piaoeda_einvoice_auth.einvoice_user.usercode
and yt_piaoeda_einvoice_auth.einvoice_user.usertype in (2,3)
and not EXISTS
(
select 1 from yt_piaoeda_einvoice_auth.einvoice_user xc where xc.usertype in (1,4) and xc.usercode = wallet_c.USERC_ID
);

INSERT INTO invoice_summary (
    inspect_status,
    vat_type,
    file_path,
    kind,
    wallet_id,
    seller_name,
    invoice_type,
    invoice_medium,
    invoice_num,
    invoice_code,
    buyer_name,
    date,
    purchaser_status,
    amount,
    bill_id,
    user_id,
    createtime
) SELECT
    1,
    inv.fplx,
    inv.FILEPATH,
    inv_ext.classification,
    wc.id AS wallet_id,
    LEFT (inv.XSF_MC, 40),
    1,
    CONVERT (inv.FPJZ, SIGNED) AS invoice_medium,
    inv.FP_HM AS invoice_num,
    inv.FP_DM AS invoice_code,
    inv.GMF_MC AS buyer_name,
    inv.KPRQ AS date,
    inv_ext.purchaserstatus AS purchaser_status,
    inv.JSHJ AS amount,
    wc.PK_INVOICE AS bill_id,
    wc.tmp_userid AS user_id,
    wc.createtime AS createtime
FROM
    invoice inv
INNER JOIN wallet_c wc ON inv.PK_INVOICE = wc.PK_INVOICE
INNER JOIN invoice_ext inv_ext ON inv.PK_INVOICE = inv_ext.pk_invoice
WHERE
    wc.PK_INVOICE NOT IN (
        SELECT
            bill_id
        FROM
            invoice_summary
        WHERE
            invoice_type = 1
        AND bill_id IS NOT NULL
    );

UPDATE wallet_invoice_tag wit, invoice_summary ins
set wit.summary_id = ins.id
where wit.id = ins.wallet_id and wit.walletid <> -1;

UPDATE invoice_summary ins,
 invoice inv,
 invoice_ext ine
SET ins.purchaser_status = ine.purchaserstatus
WHERE
    ins.invoice_type = 1
AND inv.PK_INVOICE = ine.pk_invoice
AND ins.bill_id = inv.PK_INVOICE
AND ins.purchaser_status <> ine.purchaserstatus
AND ins.createtime >= '2018-04-16';

UPDATE invoice_summary ins,
invoice inc
SET ins.invoice_medium = CONVERT ( inc.FPJZ, signed )
AND ins.vat_type = inc.FPLX
WHERE
    ins.invoice_type = 1
    AND ins.invoice_code = inc.FP_DM
    AND ins.invoice_num = inc.FP_HM
    AND ( ins.invoice_medium <> CONVERT ( inc.FPJZ, signed ) OR ins.vat_type <> inc.FPLX )
    AND ins.createtime >= '2018-04-16';

/* 下面开始处理invoice_base库 */
use yt_piaoeda_invoice_base;
/* 处理已存在的表 */
/* invoice */
alter table invoice add column `ZFRQ` datetime DEFAULT NULL COMMENT '作废日期';
/* invoice_detail */
alter table invoice_detail add column `YHZCBS` int(1) DEFAULT '0' COMMENT '优惠政策标识';
alter table invoice_detail add column `ZZSTSGL` varchar(50) DEFAULT NULL COMMENT '增值税特殊管理';
/* invoice_detail_motor*/
alter table invoice_detail_motor add column `cllx` varchar(40) DEFAULT NULL COMMENT '车辆类型';
alter table invoice_detail_motor add column `cpxh` varchar(60) DEFAULT NULL COMMENT '厂牌型号';
alter table invoice_detail_motor add column `scqymc` varchar(240) DEFAULT NULL COMMENT '生产企业名称';
alter table invoice_detail_motor add column `sfzhm` varchar(22) DEFAULT NULL COMMENT '身份证号码/组织机构代码';
alter table invoice_detail_motor add column `dz` varchar(80) DEFAULT NULL COMMENT '地址';
alter table invoice_detail_motor add column `dh` varchar(40) DEFAULT NULL COMMENT '电话';
alter table invoice_detail_motor add column `khyh` varchar(80) DEFAULT NULL COMMENT '开户银行';
alter table invoice_detail_motor add column `zh` varchar(40) DEFAULT NULL COMMENT '账户';
/* invoice_ext */
alter table invoice_ext add column `selfcheckstatus` int(11) DEFAULT NULL COMMENT '自检状态';

/*处理新添加的表*/
DROP TABLE IF EXISTS `airline_dic`;

CREATE TABLE `airline_dic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(4) NOT NULL DEFAULT '' COMMENT '航司代码',
  `name` varchar(64) NOT NULL COMMENT '航司名称',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `air_cmp_code_index` (`code`) USING BTREE COMMENT '通过code查询航空公司名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;



# Dump of table airport_dic
# ------------------------------------------------------------

DROP TABLE IF EXISTS `airport_dic`;

CREATE TABLE `airport_dic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(4) NOT NULL DEFAULT '' COMMENT '机场编码',
  `name` varchar(64) NOT NULL COMMENT '机场名称',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `airport_code_index` (`code`) USING BTREE COMMENT '通过机场编码查询机场名称索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;



# Dump of table verify_air
# ------------------------------------------------------------

DROP TABLE IF EXISTS `verify_air`;

CREATE TABLE `verify_air` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` datetime DEFAULT NULL COMMENT '填开日期',
  `ticket_num` char(15) NOT NULL COMMENT '电子客票号码',
  `check_code` varchar(20) DEFAULT NULL COMMENT '验证码',
  `agent_code` varchar(40) DEFAULT NULL COMMENT '销售单位代号',
  `issue_by` varchar(60) DEFAULT NULL COMMENT '填开单位',
  `fare` decimal(15,2) DEFAULT NULL COMMENT '票价',
  `tax` decimal(15,2) DEFAULT NULL COMMENT '其它税费',
  `total_amount` decimal(15,2) NOT NULL COMMENT '总金额',
  `user_name` varchar(60) DEFAULT NULL COMMENT '乘机人姓名',
  `user_id` char(20) DEFAULT NULL,
  `fee_without_tax` decimal(15,2) DEFAULT NULL COMMENT '金额（不含税）',
  `tax_amount` decimal(15,2) DEFAULT NULL COMMENT '税额',
  `dst` varchar(60) DEFAULT NULL COMMENT '目的地',
  `org` varchar(60) DEFAULT NULL COMMENT '始发地',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_hm` (`ticket_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='航空电子行程单查验底库';



# Dump of table verify_air_b
# ------------------------------------------------------------

DROP TABLE IF EXISTS `verify_air_b`;

CREATE TABLE `verify_air_b` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `air_id` bigint(20) NOT NULL COMMENT '航空电子行程单查验底库表主键',
  `ticket_num` char(15) NOT NULL COMMENT '电子客票号码',
  `from` varchar(60) DEFAULT NULL COMMENT '出发',
  `to` varchar(60) DEFAULT NULL COMMENT '到达',
  `dep_airport` varchar(60) DEFAULT NULL COMMENT '起飞飞机场',
  `arr_airport` varchar(60) DEFAULT NULL COMMENT '到达飞机场',
  `flight_number` varchar(40) DEFAULT NULL COMMENT '航班号',
  `carrier` varchar(20) DEFAULT NULL COMMENT '承运人',
  `seat` varchar(40) DEFAULT NULL COMMENT '舱位',
  `date` datetime DEFAULT NULL COMMENT '乘机日期',
  `time` varchar(20) DEFAULT NULL COMMENT '乘机时间',
  `fltStatus` varchar(20) DEFAULT NULL COMMENT '客票状态:OPEN FOR USE:客票有效未使用;CHECKED IN:已办理登机牌;EXCHANGED:已换开;REFUNDED:已退票;USED/FLOWN:客票已使用',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='航空电子行程单查验明细底库';



# Dump of table verify_config
# ------------------------------------------------------------

DROP TABLE IF EXISTS `verify_config`;

CREATE TABLE `verify_config` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corp_id` varchar(64) DEFAULT NULL COMMENT '公司ID',
  `srcapp` varchar(20) NOT NULL COMMENT '来源名称',
  `itf_bean` varchar(50) DEFAULT NULL COMMENT '接口bean名称',
  `itf_name` varchar(50) DEFAULT NULL COMMENT '接口描述',
  `sort` tinyint(4) NOT NULL DEFAULT '1' COMMENT '排序',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否可用',
  `type` tinyint(4) DEFAULT NULL COMMENT '查验类型，0：默认发票 1：航空发票',
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table verify_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `verify_log`;

CREATE TABLE `verify_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ip` varchar(50) DEFAULT NULL COMMENT 'IP地址',
  `userid` varchar(64) DEFAULT NULL COMMENT '用户ID',
  `srcapp` varchar(100) DEFAULT NULL,
  `appid` varchar(64) DEFAULT NULL COMMENT 'appid',
  `verifyname` varchar(100) DEFAULT NULL COMMENT '校验接口名称',
  `status` varchar(10) DEFAULT NULL COMMENT '校验结果',
  `msg` varchar(200) DEFAULT NULL COMMENT '校验信息',
  `fpdm` varchar(12) DEFAULT NULL COMMENT '发票代码',
  `fphm` varchar(15) DEFAULT NULL COMMENT '发票号码',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `VRFY_LOG_TS_IDX` (`ts`) USING BTREE,
  KEY `VRFY_LOG_STATUS` (`verifyname`(5),`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*处理一些其他的库表结构*/
/* building库*/
create database yt_piaoeda_building;

use yt_piaoeda_building;

DROP TABLE IF EXISTS `build_alarm_config`;

CREATE TABLE `build_alarm_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `job_mark` varchar(30) DEFAULT NULL COMMENT '作业标志',
  `trigger_condition` text COMMENT '触发条件',
  `enabled` char(1) DEFAULT 'N' COMMENT '是否启用：Y:启用，N:禁用',
  `corpid` varchar(64) DEFAULT NULL COMMENT '企业id',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='自动预警配置表';



# Dump of table build_prepay_tax
# ------------------------------------------------------------

DROP TABLE IF EXISTS `build_prepay_tax`;

CREATE TABLE `build_prepay_tax` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prepayment_id` int(11) NOT NULL COMMENT '预缴表主键',
  `tax_type` char(2) NOT NULL COMMENT '税种 0:增值税，1:企业所得税，2：个人所得税，3：印花税，4：水利建设基金税，5：城市维护建设税，6：教育附加税，7：地方教育附加',
  `prepay_amount` decimal(15,2) DEFAULT NULL COMMENT '金额',
  `deduction` decimal(15,2) DEFAULT NULL COMMENT '扣除额',
  `tax_amount` decimal(15,2) DEFAULT NULL COMMENT '税额',
  `tax_rate` decimal(6,6) DEFAULT NULL COMMENT '税率',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预缴税种';



# Dump of table build_prepayment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `build_prepayment`;

CREATE TABLE `build_prepayment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL COMMENT '项目id',
  `corpid` varchar(64) DEFAULT NULL,
  `orgid` int(11) DEFAULT NULL,
  `period` varchar(8) DEFAULT NULL COMMENT '预缴所属期',
  `tax_type` char(1) DEFAULT NULL COMMENT '计税方式；1-一般计税，2-简易征收（老项目），3-简易征收（甲供材）、4-简易征收（其他）',
  `final_period` varchar(8) DEFAULT NULL COMMENT '最终所属期',
  `amount` decimal(15,2) DEFAULT NULL COMMENT '发票金额',
  `prepay_path` varchar(80) DEFAULT NULL COMMENT '缴款书路径',
  `subcontractor_path` varchar(80) DEFAULT NULL COMMENT '分包方缴款书路径',
  `approval_path` varchar(80) DEFAULT NULL COMMENT '审批书文件路径',
  `other_path` varchar(80) DEFAULT NULL COMMENT '其他文件路径',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `declare_status` int(1) NOT NULL DEFAULT '1' COMMENT '申报状态 1：未申报 2：已申报',
  `declare_period` varchar(7) DEFAULT NULL COMMENT '申报所属期',
  `voucherid` varchar(32) DEFAULT NULL COMMENT '凭证号',
  `account_user` varchar(50) DEFAULT NULL COMMENT '记账人',
  `account_time` datetime DEFAULT NULL COMMENT '记账日期',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `build_index_corpId_orgId` (`corpid`,`orgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预缴表';



# Dump of table build_project
# ------------------------------------------------------------

DROP TABLE IF EXISTS `build_project`;

CREATE TABLE `build_project` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `project_name` varchar(350) NOT NULL COMMENT '项目名称',
  `project_code` varchar(50) NOT NULL COMMENT '项目编号',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `account_org_id` int(11) NOT NULL COMMENT '核算单位id',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `customer_nsrsbh` varchar(20) DEFAULT NULL COMMENT '合同相对纳税人识别号(统一社会信用代码)',
  `relative_name` varchar(100) DEFAULT NULL COMMENT '合同相对方名称',
  `tax_related_type` char(1) DEFAULT NULL COMMENT '项目涉税类型；1-建筑服务，2-出租不动产',
  `tax_method` char(1) NOT NULL DEFAULT '1' COMMENT '计税方式；1-一般计税，2-简易征收（老项目），3-简易征收（甲供材）、4-简易征收（其他）',
  `bank_and_account` varchar(190) DEFAULT NULL COMMENT '开户银行及账号',
  `address_and_phone` varchar(200) DEFAULT NULL COMMENT '开票地址及电话',
  `vat_tax` decimal(6,6) DEFAULT NULL COMMENT '增值税预交税率',
  `urban_tax` decimal(6,6) DEFAULT NULL COMMENT '城市维护建设院预交税率',
  `edu_attach_tax` decimal(6,6) DEFAULT NULL COMMENT '教育费附加预交税率',
  `local_edu_tax` decimal(6,6) DEFAULT NULL COMMENT '地方教育附加预交税率',
  `corp_income_tax` decimal(6,6) DEFAULT NULL COMMENT '企业所得税预交税率',
  `stamp_tax` decimal(6,6) DEFAULT NULL COMMENT '印花税预交税率',
  `water_conservancy_tax` decimal(6,6) DEFAULT NULL COMMENT '水利建设基金预交税率',
  `personal_tax` decimal(6,6) DEFAULT NULL COMMENT '个人所得税预交税率',
  `permit_code` varchar(50) DEFAULT NULL COMMENT '施工许可证号',
  `certificate_agency` varchar(64) DEFAULT NULL COMMENT '发证机构',
  `is_registration` char(1) DEFAULT NULL COMMENT '是否报验登记：0-否，1-是',
  `is_cross_region` char(1) DEFAULT NULL COMMENT '是否跨区域涉税事项：0-否，1-是',
  `certificate_time` datetime DEFAULT NULL COMMENT '发证或合同签订日期',
  `project_address` varchar(200) DEFAULT NULL COMMENT '项目地址',
  `start_date` datetime DEFAULT NULL COMMENT '开工日期',
  `progress` varchar(10) DEFAULT NULL COMMENT '项目进度',
  `expected_end_date` datetime DEFAULT NULL COMMENT '预计竣工时间',
  `end_date` datetime DEFAULT NULL COMMENT '实际完成时间',
  `building_scale` varchar(50) DEFAULT NULL COMMENT '建筑规模',
  `project_status` char(1) DEFAULT '2' COMMENT '项目状态：1-开工，2-在建，3-停工，4-完工末核销，5-核销',
  `verify_number` varchar(50) DEFAULT NULL COMMENT '跨区域涉税事项报验管理编号',
  `operate_method` char(1) DEFAULT NULL COMMENT '经营方式：1-建筑安装。2-装饰修饰。3-修理修配。4-加工。5-批发。6-零售。7-批零兼营。8-零批兼营。9-其他。',
  `province` varchar(16) DEFAULT NULL COMMENT '省',
  `city` varchar(16) DEFAULT NULL COMMENT '市',
  `county` varchar(32) DEFAULT NULL COMMENT '县',
  `operate_address` varchar(200) DEFAULT NULL COMMENT '跨区域经营地址',
  `effective_date_start` datetime DEFAULT NULL COMMENT '有效日期起',
  `effective_date_end` datetime DEFAULT NULL COMMENT '有效日期止',
  `region_filepath` varchar(64) DEFAULT NULL COMMENT '跨地区涉税事项表文件存储路径',
  `region_filename` varchar(64) DEFAULT NULL COMMENT '文件名',
  `collection_status` char(1) DEFAULT '1' COMMENT '项目信息台账中的项目状态：0-终止。1-启用',
  `send_emails` varchar(150) DEFAULT NULL COMMENT '需要发送邮件的邮箱',
  `invoice_amount` decimal(17,2) DEFAULT NULL COMMENT '期初已开票金额',
  `cross_region_status` char(1) DEFAULT NULL COMMENT '跨地区涉税事项表状态 0-正常 、1-终止',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目档案\r\n';



# Dump of table build_project_contract
# ------------------------------------------------------------

DROP TABLE IF EXISTS `build_project_contract`;

CREATE TABLE `build_project_contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `project_id` int(11) NOT NULL COMMENT '项目id',
  `contract_id` int(11) NOT NULL COMMENT '合同id',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目关联合同表';



# Dump of table build_subproject
# ------------------------------------------------------------

DROP TABLE IF EXISTS `build_subproject`;

CREATE TABLE `build_subproject` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `project_id` int(11) NOT NULL COMMENT '项目id',
  `subproject_code` varchar(50) DEFAULT NULL COMMENT '分包项目编号',
  `subproject_name` varchar(100) NOT NULL COMMENT '分包项目名称',
  `supplier_name` varchar(100) NOT NULL COMMENT '分包企业名称',
  `supplier_nsrsbh` varchar(20) NOT NULL COMMENT '分包企业税号',
  `begin_money` decimal(15,2) DEFAULT NULL COMMENT '期初已受票金额',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分包项目管理';



# Dump of table build_subproject_contract
# ------------------------------------------------------------

DROP TABLE IF EXISTS `build_subproject_contract`;

CREATE TABLE `build_subproject_contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `subproject_id` int(11) NOT NULL COMMENT '分包管理id',
  `contract_id` int(11) NOT NULL COMMENT '合同id',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分包管理关联合同表';



# Dump of table build_subtraction
# ------------------------------------------------------------

DROP TABLE IF EXISTS `build_subtraction`;

CREATE TABLE `build_subtraction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `nsrsbh` varchar(20) NOT NULL COMMENT '纳税人识别号',
  `nsrmc` varchar(100) NOT NULL COMMENT '纳税人名称',
  `declare_period` varchar(7) NOT NULL COMMENT '所属期',
  `declare_status` int(1) DEFAULT NULL COMMENT '申报状态 1:未申报  2：已申报',
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分包发票扣除清单';



# Dump of table prepay_declare
# ------------------------------------------------------------

DROP TABLE IF EXISTS `prepay_declare`;

CREATE TABLE `prepay_declare` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `nsrsbh` varchar(20) NOT NULL COMMENT '纳税人识别号',
  `nsrmc` varchar(100) NOT NULL COMMENT '纳税人名称',
  `declare_period` varchar(7) NOT NULL COMMENT '申报所属期',
  `declare_status` int(1) NOT NULL COMMENT '申报状态 1：未申报 2：已申报',
  `account_time_begin` datetime DEFAULT NULL COMMENT '记账日期-起',
  `account_time_end` datetime DEFAULT NULL COMMENT '记账日期-止',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='增值税预缴申报主表';



# Dump of table prepay_declare_b
# ------------------------------------------------------------

DROP TABLE IF EXISTS `prepay_declare_b`;

CREATE TABLE `prepay_declare_b` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `hid` int(11) NOT NULL COMMENT '主表主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `tax_related_type` char(1) NOT NULL COMMENT '项目涉税类型；1-建筑服务，2-出租不动产 3-销售不动产',
  `amount` decimal(15,2) DEFAULT NULL COMMENT '开票金额',
  `deduction` decimal(15,2) DEFAULT NULL COMMENT '扣除额',
  `tax_amount` decimal(15,2) DEFAULT NULL COMMENT '预征金额',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='增值税预缴申报明细表';



# Dump of table vat_fetch_record
# ------------------------------------------------------------

DROP TABLE IF EXISTS `vat_fetch_record`;

CREATE TABLE `vat_fetch_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `nsrsbh` varchar(20) NOT NULL COMMENT '纳税人识别号',
  `period` varchar(8) NOT NULL COMMENT '取数期间',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `cnp_index` (`corpid`,`nsrsbh`,`period`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应交增值税取数记录表';

/*export库*/
create database yt_piaoeda_export;

use yt_piaoeda_export;

DROP TABLE IF EXISTS `business_config`;

CREATE TABLE `business_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(3) NOT NULL COMMENT '导出类型',
  `name` varchar(50) DEFAULT NULL COMMENT '导出类型名称',
  `file_name` varchar(50) DEFAULT NULL COMMENT '文件名',
  `service_name` varchar(50) DEFAULT NULL COMMENT '服务名',
  `fetch_bean` varchar(50) DEFAULT NULL COMMENT '自定义取数BEAN名',
  `data_clazz` varchar(150) DEFAULT NULL COMMENT '查询结果实体类',
  `benable` char(1) NOT NULL DEFAULT 'Y' COMMENT '节点是否可用，N为停用',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='导出业务配置表';

LOCK TABLES `business_config` WRITE;
/*!40000 ALTER TABLE `business_config` DISABLE KEYS */;

INSERT INTO `business_config` (`id`, `type`, `name`, `file_name`, `service_name`, `fetch_bean`, `data_clazz`, `benable`, `ts`, `createtime`)
VALUES
	(1,'1','采购台账','受票数据','SERVICE-INPUT-TAX/input-tax','purchaseBusiness','','Y','2019-03-19 15:37:21','2019-03-19 15:37:21'),
	(2,'2','发票自检','自检明细','SERVICE-INPUT-TAX/input-tax','selfCheckBusiness','','Y','2019-03-07 15:04:05','2019-03-04 21:18:38'),
	(3,'3','供应商黑名单','供应商黑名单','SERVICE-INPUT-TAX/input-tax','supplierBlacklistBusiness',NULL,'Y','2019-03-25 17:18:38','2019-03-25 17:18:35'),
	(4,'4','查验历史记录','历史记录','SERVICE-INPUT-TAX/input-tax','verifyHisBusiness',NULL,'Y','2019-04-26 15:05:30','2019-04-26 15:03:57'),
	(5,'5','分包项目发票联查','分包项目发票联查','SERVICE-BUILDING/building','subprojectLinkBusiness',NULL,'Y','2019-05-23 17:26:57','2019-05-23 17:24:45'),
	(6,'6','预缴管理','分包明细记录','SERVICE-BUILDING/building','subAccountExportBusiness',NULL,'Y','2019-05-30 15:05:30','2019-05-30 15:03:57'),
	(7,'7','航空客票','航空客票受票数据','SERVICE-INPUT-TAX/input-tax','airExportBusiness',NULL,'Y','2019-05-30 15:05:30','2019-05-30 15:03:57'),
	(8,'8','火车票','火车票受票数据','SERVICE-INPUT-TAX/input-tax','trainExportBusiness',NULL,'Y','2019-05-30 15:05:30','2019-05-30 15:03:57'),
	(9,'9','客运汽车发票','客运汽车发票受票数据','SERVICE-INPUT-TAX/input-tax','passengerExportBusiness',NULL,'Y','2019-05-30 15:05:30','2019-05-30 15:03:57'),
	(10,'10','出租车发票','出租车发票受票数据','SERVICE-INPUT-TAX/input-tax','taxiExportBusiness',NULL,'Y','2019-05-30 15:05:30','2019-05-30 15:03:57'),
	(11,'11','过路费发票','过路费发票受票数据','SERVICE-INPUT-TAX/input-tax','tollsExportBusiness',NULL,'Y','2019-05-30 15:05:30','2019-05-30 15:03:57'),
	(12,'12','机打发票','机打发票受票数据','SERVICE-INPUT-TAX/input-tax','machineExportBusiness',NULL,'Y','2019-05-30 15:05:30','2019-05-30 15:03:57'),
	(13,'13','定额发票','定额发票受票数据','SERVICE-INPUT-TAX/input-tax','quotaExportBusiness',NULL,'Y','2019-05-30 15:05:30','2019-05-30 15:03:57'),
	(14,'14','供应商关系','供应商关系数据','SERVICE-BASEDOC','supplierExportBusiness',NULL,'Y','2019-07-16 18:37:32','2019-07-16 18:37:32'),
	(15,'15','分包发票扣除清单明细导出','分包发票扣除清单明细数据','SERVICE-BUILDING/building','buildSubtractExportBusiness',NULL,'Y','2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(16,'16','合同台账','合同台账数据','SERVICE-BASEDOC','contractExportBusiness',NULL,'Y','2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(17,'17','印花税台账','印花税台账数据','SERVICE-OTHER-TAX/other-tax','stampTaxAccountExportBusiness',NULL,'Y','2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(18,'18','其他票种台账','其他发票受票数据','SERVICE-INPUT-TAX/input-tax','otherExportBusiness',NULL,'Y','2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(19,'19','项目信息查询结果导出','项目信息','SERVICE-BUILDING/building','buildProjectExportBusiness',NULL,'Y','2019-11-07 10:46:04','2019-11-07 10:46:04'),
	(20,'20','应交增值税报表按组织维度查询结果导出','应交增值税报表','SERVICE-BUILDING/building','vatExportBusiness',NULL,'Y','2019-12-12 19:43:59','2019-12-12 19:43:59'),
	(21,'21','应交增值税报表按项目维度查询结果导出','应交增值税报表','SERVICE-BUILDING/building','vatProExportBusiness',NULL,'Y','2019-12-12 19:43:59','2019-12-12 19:43:59'),
	(22,'22','退税勾选','退税勾选查询数据','SERVICE-INPUT-TAX/input-tax','taxRebateCheckExportBusiness',NULL,'Y','2019-12-12 19:43:59','2019-12-12 19:43:59'),
	(23,'24','科目对照数据','科目对照数据','SERVICE-INCOME-TAX/income-tax','commonMappingExport',NULL,'Y','2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(25,'25','一般税负率统计表查询结果导出','一般税负率统计表','SERVICE-BUILDING/building','taxBearingRateExportBusiness',NULL,'Y','2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(26,'26','预缴管理查询结果导出','预缴记录信息','SERVICE-BUILDING/building','buildPrepaymentExportBusiness',NULL,'Y','2019-12-12 20:14:08','2019-12-12 20:14:08'),
	(27,'27','按核算单位税负率统计表查询结果导出','按核算单位税负率统计表','SERVICE-BUILDING/building','accountTaxBearingRateExportBusiness',NULL,'Y','2019-12-12 19:44:27','2019-12-12 19:44:27');

/*!40000 ALTER TABLE `business_config` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table export_task
# ------------------------------------------------------------

DROP TABLE IF EXISTS `export_task`;

CREATE TABLE `export_task` (
  `task_id` bigint(20) NOT NULL COMMENT '任务编码',
  `busi_id` int(11) NOT NULL COMMENT '导出业务配置表主键',
  `task_status` int(2) NOT NULL DEFAULT '1' COMMENT '任务状态: 1、处理中；2、处理成功；3、处理失败',
  `file_path` varchar(100) DEFAULT NULL COMMENT '文件路径',
  `task_name` varchar(100) DEFAULT NULL COMMENT '任务名',
  `reason` varchar(200) DEFAULT NULL COMMENT '失败原因',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `userid` varchar(64) DEFAULT NULL COMMENT '用户id',
  `start_time` datetime DEFAULT NULL COMMENT '任务发起时间',
  `end_time` datetime DEFAULT NULL COMMENT '任务完成时间',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`task_id`),
  KEY `idx_taskid` (`task_id`) USING BTREE,
  KEY `idx_userid` (`userid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='导出任务表';



# Dump of table globle_item_config
# ------------------------------------------------------------

DROP TABLE IF EXISTS `globle_item_config`;

CREATE TABLE `globle_item_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `field` varchar(30) DEFAULT NULL COMMENT '实体属性名',
  `column_zh` varchar(50) DEFAULT NULL COMMENT 'Excel列名',
  `benable` char(1) DEFAULT 'N' COMMENT '是否可编辑',
  `checked` char(1) DEFAULT 'N' COMMENT '是否勾选',
  `busi_id` int(11) NOT NULL COMMENT '业务类型编码',
  `sort` int(3) DEFAULT NULL COMMENT '字段排序',
  `processer` varchar(50) DEFAULT NULL COMMENT 'Excel字段格式处理类',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='全局导出项配置表';

LOCK TABLES `globle_item_config` WRITE;
/*!40000 ALTER TABLE `globle_item_config` DISABLE KEYS */;

INSERT INTO `globle_item_config` (`id`, `field`, `column_zh`, `benable`, `checked`, `busi_id`, `sort`, `processer`, `ts`, `createtime`)
VALUES
	(1,'fpDm','发票代码','Y','N',1,1,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(2,'fpHm','发票号码','N','Y',1,2,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(3,'kprq','开票日期','N','Y',1,3,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(4,'gmfMc','购买方名称','Y','N',1,4,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(5,'gmfDzdh','购买方地址电话','Y','N',1,5,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(6,'gmfNsrsbh','购买方税号','Y','N',1,6,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(7,'xsfMc','销售方名称','Y','Y',1,7,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(8,'xsfDzdh','销售方地址电话','Y','N',1,8,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(9,'xsfNsrsbh','销售方税号','Y','N',1,9,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(10,'hjje','金额','Y','N',1,10,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(11,'hjse','税额','Y','N',1,11,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(12,'jshj','价税合计','N','Y',1,12,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(13,'bz','备注','Y','N',1,13,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(14,'submitter','提交人','Y','Y',1,14,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(15,'submitDate','提交日期','Y','Y',1,15,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(16,'purchaser','采购业务员','Y','Y',1,16,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(17,'vnote','采购台账备注','Y','N',1,17,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(18,'voucherid','凭证号','Y','N',1,18,NULL,'2019-03-19 15:37:07','2019-03-19 15:37:07'),
	(19,'srcBillType','来源业务系统','Y','N',1,19,NULL,'2019-03-19 15:37:08','2019-03-19 15:37:08'),
	(20,'srcBillCode','业务系统单据号','Y','N',1,20,NULL,'2019-03-19 15:37:08','2019-03-19 15:37:08'),
	(21,'fplx','发票种类','Y','Y',1,21,NULL,'2019-03-19 15:37:08','2019-03-19 15:37:08'),
	(22,'totalOutMny','累计转出税额','Y','N',1,22,NULL,'2019-03-19 15:37:08','2019-03-19 15:37:08'),
	(23,'verifyStatus','认证状态','Y','N',1,23,NULL,'2019-03-19 15:37:08','2019-03-19 15:37:08'),
	(24,'manualVerifyStatus','手工认证状态','Y','N',1,24,NULL,'2019-03-19 15:37:08','2019-03-19 15:37:08'),
	(25,'purchaserstatus','状态','Y','Y',1,25,NULL,'2019-03-19 15:37:08','2019-03-19 15:37:08'),
	(26,'accountName','进项对应科目','Y','N',1,26,NULL,'2019-03-19 15:37:08','2019-03-19 15:37:08'),
	(27,'bratio','是否比例转出','Y','Y',1,27,NULL,'2019-03-19 15:37:08','2019-03-19 15:37:08'),
	(28,'fpzt','发票状态','Y','N',1,28,NULL,'2019-03-19 15:37:08','2019-03-19 15:37:08'),
	(49,'orgName','受票组织名称','Y','Y',2,1,NULL,'2019-03-07 15:06:28','2019-03-02 16:51:56'),
	(50,'fplxName','发票种类','Y','Y',2,2,NULL,'2019-03-07 15:06:28','2019-03-02 16:51:56'),
	(51,'fpHm','发票号码','Y','Y',2,3,NULL,'2019-03-07 15:06:28','2019-03-02 16:51:56'),
	(52,'xsfMc','销售方名称','Y','Y',2,4,NULL,'2019-03-07 15:06:28','2019-03-02 16:51:56'),
	(53,'xsfNsrsbh','销方税号','Y','Y',2,5,NULL,'2019-03-07 15:06:29','2019-03-02 16:51:56'),
	(54,'kprq','开票日期','Y','Y',2,6,NULL,'2019-03-07 15:06:29','2019-03-02 16:51:56'),
	(55,'submitDate','提交日期','Y','Y',2,7,NULL,'2019-03-07 15:06:29','2019-03-02 16:51:56'),
	(56,'jshj','价税合计','Y','Y',2,8,NULL,'2019-03-07 15:06:29','2019-03-02 16:51:56'),
	(57,'fpztOldName','原发票状态','Y','Y',2,9,NULL,'2019-03-07 15:06:29','2019-03-02 16:51:56'),
	(58,'fpztNowName','现发票状态','Y','Y',2,10,NULL,'2019-03-07 15:06:29','2019-03-02 16:51:56'),
	(59,'selfCheckStatus','发票自检状态','Y','N',1,29,NULL,'2019-03-07 15:22:34','2019-03-02 16:51:57'),
	(60,'name','供应商名称','Y','N',3,1,NULL,'2019-03-25 17:20:07','2019-03-25 17:19:55'),
	(61,'nsrsbh','税号','Y','N',3,2,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(62,'reason','原因','Y','N',3,3,NULL,'2019-03-25 17:21:14','2019-03-25 17:21:14'),
	(63,'submitDate','提交日期','Y','N',3,4,NULL,'2019-03-25 17:21:38','2019-03-25 17:21:38'),
	(64,'submitter','提交人','Y','N',3,5,NULL,'2019-03-25 17:23:06','2019-03-25 17:23:06'),
	(65,'src','来源','Y','N',3,6,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(66,'accountUser','记账人','Y','N',1,30,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(67,'accountTime','记账日期','Y','N',1,31,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(68,'accountNote','记账备注','Y','N',1,32,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(69,'time','查验时间','Y','Y',4,1,NULL,'2019-04-26 15:15:45','2019-04-26 15:12:51'),
	(70,'username','查验人','Y','Y',4,2,NULL,'2019-04-26 15:13:25','2019-04-26 15:13:25'),
	(71,'verifyTypeName','查验方式','Y','Y',4,3,NULL,'2019-04-26 15:15:53','2019-04-26 15:13:57'),
	(72,'orgName','受票组织','Y','Y',4,4,NULL,'2019-04-26 15:14:59','2019-04-26 15:14:59'),
	(73,'fpDm','发票代码','Y','Y',4,5,NULL,'2019-04-26 15:16:09','2019-04-26 15:16:09'),
	(74,'fpHm','发票号码','Y','Y',4,6,NULL,'2019-04-26 15:16:34','2019-04-26 15:16:34'),
	(75,'fplx','发票种类','Y','Y',4,7,NULL,'2019-04-26 15:17:04','2019-04-26 15:17:04'),
	(76,'resultCode','查验结果','Y','Y',4,8,NULL,'2019-04-26 15:18:20','2019-04-26 15:18:20'),
	(77,'fpHm','发票号码','Y','Y',5,1,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(78,'fpDm','发票代码','Y','Y',5,2,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(79,'kprq','开票日期','Y','Y',5,3,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(80,'xsfMc','销售方名称','Y','Y',5,4,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(81,'jshj','价税合计','Y','Y',5,5,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(82,'hjse','税额','Y','Y',5,6,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(83,'fplxName','发票种类','Y','Y',5,7,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(84,'collectionTypeName','来源','Y','Y',5,8,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(85,'purchaserstatusName','状态','Y','Y',5,9,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(86,'totalOutMny','累计转出税额','Y','Y',5,10,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(87,'verifyStatusName','认证状态','Y','Y',5,11,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(88,'prepayDeductionName','扣除状态','Y','Y',5,12,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(89,'prepayPeriod','预交所属期','Y','Y',5,13,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(90,'voucherid','凭证号','Y','Y',5,14,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(91,'fpdm','发票代码','Y','Y',6,1,NULL,'2019-06-17 13:26:01','2019-06-17 13:26:01'),
	(92,'fphm','发票号码','Y','Y',6,2,NULL,'2019-06-17 13:26:01','2019-06-17 13:26:01'),
	(93,'kprq','开票日期','Y','Y',6,3,NULL,'2019-06-17 13:26:01','2019-06-17 13:26:01'),
	(94,'xsfMc','销售方名称','Y','Y',6,4,NULL,'2019-06-17 13:26:02','2019-06-17 13:26:02'),
	(95,'jshj','价税合计','Y','Y',6,5,NULL,'2019-06-17 13:26:02','2019-06-17 13:26:02'),
	(96,'hjse','税额','Y','Y',6,6,NULL,'2019-06-17 13:26:02','2019-06-17 13:26:02'),
	(97,'fplx','发票种类','Y','Y',6,7,NULL,'2019-06-17 13:26:02','2019-06-17 13:26:02'),
	(98,'outMoney','累计转出税额','Y','Y',6,8,NULL,'2019-06-17 13:26:02','2019-06-17 13:26:02'),
	(99,'verifyStatus','认证状态','Y','Y',6,9,NULL,'2019-06-17 13:26:02','2019-06-17 13:26:02'),
	(100,'prepayDeduction','扣除状态','Y','Y',6,10,NULL,'2019-06-17 13:26:02','2019-06-17 13:26:02'),
	(101,'accountType','来源','Y','Y',6,11,NULL,'2019-06-17 13:26:02','2019-06-17 13:26:02'),
	(102,'voucherid','凭证号','Y','Y',6,12,NULL,'2019-06-17 13:26:02','2019-06-17 13:26:02'),
	(103,'purchaserstatus','状态','Y','Y',6,13,NULL,'2019-06-17 13:26:02','2019-06-17 13:26:02'),
	(104,'projectName','项目名称','Y','N',1,33,NULL,'2019-03-25 17:23:26','2019-03-25 17:23:26'),
	(107,'number','电子客票号码','Y','Y',7,1,NULL,'2019-03-11 14:28:27','2019-03-02 16:51:56'),
	(108,'date','开票日期','Y','Y',7,2,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(109,'issueBy','填开单位','Y','Y',7,3,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(110,'userName','乘机人姓名','Y','Y',7,4,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(111,'manualVerifyStatus','抵扣状态','Y','Y',7,5,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(112,'period','抵扣期间','Y','Y',7,6,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(113,'feeWithoutTax','金额','Y','Y',7,7,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(114,'taxAmount','税额','Y','Y',7,8,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(115,'totalAmount','价税合计','Y','Y',7,9,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(116,'purchaserstatus','报销状态','Y','Y',7,10,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(117,'submitter','提交人','Y','Y',7,11,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(118,'submitDate','提交日期','Y','Y',7,12,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(119,'reimburseUser','报销人','Y','Y',7,13,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(120,'reimburseDate','报销日期','Y','N',7,14,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(121,'reimburseMoney','报销金额','Y','N',7,15,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(122,'vnote','报销备注','Y','N',7,16,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(123,'voucherid','凭证号','Y','N',7,17,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(124,'srcBillType','来源业务系统','Y','N',7,18,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(125,'srcBillCode','业务系统单据号','Y','N',7,19,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(126,'paymentStatus','支付状态','Y','N',7,20,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(127,'totalOutMny','累计转出税额','Y','N',7,21,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(128,'accountName','进项对应科目','Y','N',7,22,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(129,'bratio','是否比例转出','Y','N',7,23,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(130,'accountUser','记账人','Y','N',7,24,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(131,'accountTime','记账日期','Y','N',7,25,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(132,'accountNote','记账备注','Y','N',7,26,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(133,'fare','票价','Y','N',7,27,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(134,'tax','税费','Y','N',7,28,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(135,'fuelSurcharge','燃油附加费','Y','N',7,29,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(136,'caacDevelopFund','民航发展基金','Y','N',7,30,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(137,'insurance','保险费','Y','N',7,31,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(138,'userId','证件号','Y','N',7,32,NULL,'2019-07-16 18:39:02','2019-03-11 14:28:27'),
	(139,'number','火车票号','Y','Y',8,1,NULL,'2019-03-11 14:28:27','2019-03-02 16:51:56'),
	(140,'date','乘车日期','Y','Y',8,2,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(141,'origin','出发','Y','Y',8,3,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(142,'destination','到达','Y','Y',8,4,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(143,'trainNum','车次','Y','Y',8,5,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(144,'name','乘车人姓名','Y','Y',8,6,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(145,'manualVerifyStatus','抵扣状态','Y','Y',8,7,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(146,'period','抵扣期间','Y','Y',8,8,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(147,'feeWithoutTax','金额','Y','Y',8,9,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(148,'taxAmount','税额','Y','Y',8,10,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(149,'totalAmount','价税合计','Y','Y',8,11,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(150,'purchaserstatus','报销状态','Y','Y',8,12,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(151,'submitter','提交人','Y','Y',8,13,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(152,'submitDate','提交日期','Y','Y',8,14,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(153,'reimburseUser','报销人','Y','Y',8,15,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(154,'reimburseDate','报销日期','Y','N',8,16,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(155,'reimburseMoney','报销金额','Y','N',8,17,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(156,'vnote','报销备注','Y','N',8,18,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(157,'voucherid','凭证号','Y','N',8,19,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(158,'srcBillType','来源业务系统','Y','N',8,20,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(159,'srcBillCode','业务系统单据号','Y','N',8,21,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(160,'paymentStatus','支付状态','Y','N',8,22,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(161,'totalOutMny','累计转出税额','Y','N',8,23,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(162,'accountName','进项对应科目','Y','N',8,24,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(163,'bratio','是否比例转出','Y','N',8,25,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(164,'accountUser','记账人','Y','Y',8,26,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(165,'accountTime','记账日期','Y','N',8,27,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(166,'accountNote','记账备注','Y','N',8,28,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(167,'invoiceCode','发票代码','Y','Y',9,1,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(168,'invoiceNum','发票号码','Y','Y',9,2,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(169,'date','乘车日期','Y','Y',9,3,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(170,'entrance','出发','Y','Y',9,4,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(171,'exit','到达','Y','Y',9,5,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(172,'name','乘车人姓名','Y','Y',9,6,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(173,'manualVerifyStatus','抵扣状态','Y','Y',9,7,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(174,'period','抵扣期间','Y','Y',9,8,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(175,'feeWithoutTax','金额','Y','Y',9,9,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(176,'taxAmount','税额','Y','Y',9,10,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(177,'totalAmount','价税合计','Y','Y',9,11,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(178,'purchaserstatus','报销状态','Y','Y',9,12,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(179,'submitter','提交人','Y','Y',9,13,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(180,'submitDate','提交日期','Y','Y',9,14,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(181,'reimburseUser','报销人','Y','Y',9,15,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(182,'reimburseDate','报销日期','Y','N',9,16,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(183,'reimburseMoney','报销金额','Y','N',9,17,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(184,'vnote','报销备注','Y','N',9,18,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(185,'voucherid','凭证号','Y','N',9,19,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(186,'srcBillType','来源业务系统','Y','N',9,20,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(187,'srcBillCode','业务系统单据号','Y','N',9,21,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(188,'paymentStatus','支付状态','Y','N',9,22,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(189,'totalOutMny','累计转出税额','Y','N',9,23,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(190,'accountName','进项对应科目','Y','N',9,24,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(191,'bratio','是否比例转出','Y','N',9,25,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(192,'accountUser','记账人','Y','N',9,26,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(193,'accountTime','记账日期','Y','N',9,27,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(194,'accountNote','记账备注','Y','N',9,28,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(195,'invoiceCode','发票代码','Y','Y',10,1,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(196,'invoiceNum','发票号码','Y','Y',10,2,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(197,'date','乘车日期','Y','Y',10,3,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(198,'carNum','车牌号','Y','Y',10,4,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(199,'startTime','上车时间','Y','Y',10,5,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(200,'endTime','下车时间','Y','Y',10,6,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(201,'totalAmount','金额','Y','Y',10,7,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(202,'purchaserstatus','报销状态','Y','Y',10,8,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(203,'submitter','提交人','Y','Y',10,9,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(204,'submitDate','提交日期','Y','Y',10,10,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(205,'reimburseUser','报销人','Y','Y',10,11,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(206,'suspectStatus','疑票状态','Y','N',10,12,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(207,'suspectRule','疑票规则','Y','N',10,13,NULL,'2019-08-06 23:15:05','2019-03-11 14:28:27'),
	(208,'reimburseDate','报销日期','Y','Y',10,14,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(209,'reimburseMoney','报销金额','Y','N',10,15,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(210,'vnote','报销备注','Y','N',10,16,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(211,'accountUser','记账人','Y','N',10,17,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(212,'accountTime','记账日期','Y','N',10,18,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(213,'accountNote','记账备注','Y','N',10,19,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(214,'invoiceCode','发票代码','Y','Y',11,1,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(215,'invoiceNum','发票号码','Y','Y',11,2,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(216,'date','日期','Y','Y',11,3,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(217,'time','时间','Y','Y',11,4,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(218,'entrance','入口','Y','Y',11,5,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(219,'exit','出口','Y','Y',11,6,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(220,'totalAmount','金额','Y','Y',11,7,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(221,'purchaserstatus','报销状态','Y','Y',11,8,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(222,'submitter','提交人','Y','Y',11,9,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(223,'submitDate','提交日期','Y','Y',11,10,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(224,'reimburseUser','报销人','Y','Y',11,11,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(225,'suspectStatus','疑票状态','Y','N',11,12,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(226,'suspectRule','疑票规则','Y','N',11,13,NULL,'2019-08-06 23:15:05','2019-03-11 14:28:27'),
	(227,'reimburseDate','报销日期','Y','N',11,14,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(228,'reimburseMoney','报销金额','Y','N',11,15,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(229,'vnote','报销备注','Y','N',11,16,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(230,'voucherid','凭证号','Y','N',11,17,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(231,'srcBillType','来源业务系统','Y','N',11,18,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(232,'srcBillCode','业务系统单据号','Y','N',11,19,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(233,'paymentStatus','支付状态','Y','N',11,20,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(234,'accountUser','记账人','Y','N',11,21,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(235,'accountTime','记账日期','Y','N',11,22,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(236,'accountNote','记账备注','Y','N',11,23,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(237,'invoiceNum','发票号码','Y','Y',12,1,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(238,'date','开票日期','Y','Y',12,2,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(239,'sellerName','销售方名称','Y','Y',12,3,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(240,'totalAmount','合计金额','Y','Y',12,4,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(241,'purchaserstatus','报销状态','Y','Y',12,5,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(242,'submitter','提交人','Y','Y',12,6,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(243,'submitDate','提交日期','Y','Y',12,7,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(244,'reimburseUser','报销人','Y','Y',12,8,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(245,'reimburseDate','报销日期','Y','N',12,9,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(246,'reimburseMoney','报销金额','Y','N',12,10,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(247,'vnote','报销备注','Y','N',12,11,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(248,'voucherid','凭证号','Y','N',12,12,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(249,'srcBillType','来源业务系统','Y','N',12,13,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(250,'srcBillCode','业务系统单据号','Y','N',12,14,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(251,'paymentStatus','支付状态','Y','N',12,15,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(252,'accountUser','记账人','Y','N',12,16,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(253,'accountTime','记账日期','Y','N',12,17,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(254,'accountNote','记账备注','Y','N',12,18,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(255,'invoiceCode','发票代码','Y','Y',13,1,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(256,'invoiceNum','发票号码','Y','Y',13,2,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(257,'productName','项目','Y','Y',13,3,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(258,'totalAmount','金额','Y','Y',13,4,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(259,'purchaserstatus','报销状态','Y','Y',13,5,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(260,'submitter','提交人','Y','Y',13,6,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(261,'submitDate','提交日期','Y','Y',13,7,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(262,'reimburseUser','报销人','Y','Y',13,8,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(263,'reimburseDate','报销日期','Y','N',13,9,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(264,'reimburseMoney','报销金额','Y','N',13,10,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(265,'vnote','报销备注','Y','N',13,11,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(266,'voucherid','凭证号','Y','N',13,12,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(267,'srcBillType','来源业务系统','Y','N',13,13,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(268,'srcBillCode','业务系统单据号','Y','N',13,14,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(269,'paymentStatus','支付状态','Y','N',13,15,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(270,'accountUser','记账人','Y','N',13,16,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(271,'accountTime','记账日期','Y','N',13,17,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(272,'accountNote','记账备注','Y','N',13,18,NULL,'2019-03-11 14:28:27','2019-03-11 14:28:27'),
	(307,'applyDate','申请日期','Y','Y',14,1,NULL,'2019-07-16 18:37:38','2019-07-16 18:37:38'),
	(308,'supplierMc','供应商名称','Y','Y',14,2,NULL,'2019-07-16 18:37:38','2019-07-16 18:37:38'),
	(309,'supplierNsrsbh','供应商税号','Y','Y',14,3,NULL,'2019-07-16 18:37:38','2019-07-16 18:37:38'),
	(310,'supplierCode','供应商编号','Y','Y',14,4,NULL,'2019-07-16 18:37:38','2019-07-16 18:37:38'),
	(311,'contactNumber','联系电话','Y','N',14,5,NULL,'2019-07-16 18:37:38','2019-07-16 18:37:38'),
	(312,'purchaserMc','采购商名称','Y','Y',14,6,NULL,'2019-07-16 18:37:38','2019-07-16 18:37:38'),
	(313,'purchaserNsrsbh','采购商税号','Y','N',14,7,NULL,'2019-07-16 18:37:38','2019-07-16 18:37:38'),
	(314,'purOrgName','采购商受票组织名称','Y','N',14,8,NULL,'2019-07-16 18:37:38','2019-07-16 18:37:38'),
	(315,'accountType','关联台账','Y','Y',14,9,NULL,'2019-07-16 18:37:38','2019-07-16 18:37:38'),
	(316,'approveStatus','关联状态','Y','Y',14,10,NULL,'2019-07-16 18:37:38','2019-07-16 18:37:38'),
	(317,'vnote','备注','Y','N',14,11,NULL,'2019-07-16 18:37:39','2019-07-16 18:37:39'),
	(318,'nsrsbh','税号','Y','Y',15,1,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(319,'nsrMc','纳税人名称','Y','Y',15,2,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(320,'declarePeriod','所属期','Y','Y',15,3,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(321,'orgName','组织','Y','Y',15,4,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(322,'projectName','项目名称','Y','Y',15,5,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(323,'fpDm','发票代码','Y','Y',15,6,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(324,'fpHm','发票号码','Y','Y',15,7,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(325,'kprq','开票日期','Y','Y',15,8,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(326,'xsfMc','销售方名称','Y','Y',15,9,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(327,'jshj','价税合计','Y','Y',15,10,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(328,'hjse','税额','Y','Y',15,11,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(329,'fplx','发票种类','Y','Y',15,12,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(330,'status','状态','N','Y',15,13,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(331,'totalOutMny','累计转出税额','N','Y',15,14,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(332,'verifyName','认证状态','N','Y',15,15,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(333,'prepayDeduction','扣除状态','N','Y',15,16,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(334,'prepayPeriod','预交所属期','N','Y',15,17,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(335,'type','来源','N','Y',15,18,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(336,'voucherid','凭证号','N','Y',15,19,NULL,'2019-08-26 15:17:00','2019-08-26 15:17:00'),
	(337,'voucherid','凭证号','Y','N',10,20,NULL,'2019-08-26 21:03:47','2019-08-26 21:03:47'),
	(338,'srcBillType','来源业务系统','Y','N',10,21,NULL,'2019-08-26 21:03:47','2019-08-26 21:03:47'),
	(339,'srcBillCode','业务系统单据号','Y','N',10,22,NULL,'2019-08-26 21:03:47','2019-08-26 21:03:47'),
	(340,'paymentStatus','支付状态','Y','N',10,23,NULL,'2019-08-26 21:03:47','2019-08-26 21:03:47'),
	(341,'nsrsbh','税号','Y','Y',16,1,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(342,'nsrName','纳税人名称','Y','Y',16,2,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(343,'orgName','组织名称','Y','Y',16,3,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(344,'code','合同编号','Y','Y',16,4,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(345,'name','合同名称','Y','Y',16,5,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(346,'relativeName','合同相对方名称','Y','Y',16,6,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(347,'relativeNsrsbh','合同相对方税号','Y','Y',16,7,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(348,'amount','合同金额','Y','Y',16,8,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(349,'validDate','合同有效期','Y','Y',16,9,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(350,'contractStatus','合同状态','Y','Y',16,10,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(351,'contractType','合同类型','Y','Y',16,11,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(352,'isFrame','是否框架合同','Y','N',16,12,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(353,'signDate','合同签订日期','Y','N',16,13,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(354,'voucherType','应税凭证名称','Y','N',16,14,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(355,'createTime','登记时间','Y','N',16,15,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(356,'paymentType','收支类型','Y','N',16,16,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(357,'note','备注','Y','N',16,17,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(358,'nsrsbh','税号','Y','Y',17,1,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(359,'nsrmc','纳税人名称','Y','Y',17,2,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(360,'orgName','组织名称','Y','Y',17,3,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(361,'voucherType','应税凭证名称','Y','Y',17,4,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(362,'contractCode','合同编号','Y','Y',17,5,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(363,'contractName','合同/帐簿/证照名称','Y','Y',17,6,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(364,'je','计税金额或件数','Y','Y',17,7,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(365,'slThousandths','适用税率','Y','Y',17,8,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(366,'payableTax','应纳税额','Y','Y',17,9,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(367,'paidTax','已缴税额','Y','Y',17,10,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(368,'relativeName','合同相对方名称','Y','N',17,11,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(369,'relativeNsrsbh','合同相对方税号','Y','N',17,12,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(370,'prepayTaxBureau','预缴税务局','Y','N',17,13,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(371,'period','税款所属期','Y','N',17,14,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(372,'paymentType','收支类型','Y','N',17,15,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(373,'ischarged','是否计费','Y','Y',4,9,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(374,'suspectStatus','疑票状态','Y','N',12,19,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(375,'suspectRule','疑票规则','Y','N',12,20,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(376,'invoiceCode','发票代码','Y','Y',18,1,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(377,'invoiceNum','发票号码','Y','Y',18,2,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(378,'date','日期','Y','Y',18,3,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(379,'totalAmount','金额','Y','Y',18,4,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(380,'purchaserstatus','报销状态','Y','Y',18,5,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(381,'submitter','提交人','Y','Y',18,6,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(382,'submitDate','提交日期','Y','Y',18,7,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(383,'reimburseUser','报销人','Y','Y',18,8,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(384,'reimburseDate','报销日期','Y','N',18,9,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(385,'reimburseMoney','报销金额','Y','N',18,10,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(386,'vnote','报销备注','Y','N',18,11,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(387,'voucherid','凭证号','Y','N',18,12,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(388,'srcBillType','来源业务系统','Y','N',18,13,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(389,'srcBillCode','业务系统单据号','Y','N',18,14,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(390,'paymentStatus','支付状态','Y','N',18,15,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(391,'accountUser','记账人','Y','N',18,16,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(392,'accountTime','记账日期','Y','N',18,17,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(393,'accountNote','记账备注','Y','N',18,18,NULL,'2019-10-31 14:33:19','2019-10-31 14:33:19'),
	(394,'nsrsbh','税号','N','Y',19,10,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(395,'nsrmc','纳税人名称','N','Y',19,20,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(396,'orgname','组织名称','Y','N',19,30,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(397,'projectName','项目名称','N','Y',19,40,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(398,'accountOrgName','核算单位','Y','N',19,50,NULL,'2019-11-08 14:12:57','2019-11-07 14:19:22'),
	(399,'taxMethod','计税方式','N','Y',19,60,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(400,'totalContractAmount','合同合计金额','N','Y',19,70,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(401,'invoiceAmount','期初已开票金额','Y','N',19,80,NULL,'2019-11-07 14:19:22','2019-11-07 14:19:22'),
	(402,'relativeName','合同相对方名称','N','Y',19,90,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(403,'isCrossRegion','是否跨区','N','Y',19,100,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(404,'verifyNumber','跨区域涉税事项报验管理编号','Y','N',19,110,NULL,'2019-11-07 14:31:46','2019-11-07 14:19:22'),
	(405,'effectiveDateStart','跨区域涉税事项报验管理有效期','Y','N',19,120,NULL,'2019-11-07 15:43:43','2019-11-07 14:19:22'),
	(406,'crossRegionStatus','跨地区涉税事项表状态','Y','N',19,130,NULL,'2019-11-07 14:31:46','2019-11-07 14:19:22'),
	(407,'isPrepay','是否预交','N','Y',19,140,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(408,'iscomplete','是否完工','N','Y',19,150,NULL,'2019-11-07 15:43:57','2019-03-25 17:20:49'),
	(409,'permitCode','施工许可证号','Y','N',19,160,NULL,'2019-11-07 14:31:46','2019-11-07 14:19:22'),
	(410,'progress','完工进度%','Y','N',19,170,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(411,'projectAddress','项目地址','Y','N',19,180,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(412,'projectStatus','项目状态','Y','N',19,190,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(413,'taxRelatedType','项目涉税类型','Y','N',19,200,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(414,'vatTax','增值税预交税率','Y','N',19,210,NULL,'2019-11-07 14:19:22','2019-11-07 14:19:22'),
	(415,'urbanTax','城建税预交税率','Y','N',19,220,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(416,'eduAttachTax','教育费预交税率','Y','N',19,230,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(417,'localEduTax','地方教育预交税率','Y','N',19,240,NULL,'2019-11-07 14:19:22','2019-11-07 14:19:22'),
	(418,'stampTax','印花税预交税率','Y','N',19,250,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(419,'corpIncomeTax','企业所得税预交税率','Y','N',19,260,NULL,'2019-03-25 17:20:49','2019-03-25 17:20:49'),
	(420,'personalTax','个人所得税预交税率','Y','N',19,270,NULL,'2019-11-07 14:31:46','2019-11-07 14:31:46'),
	(421,'waterConservancyTax','水利基金预交税率','Y','N',19,280,NULL,'2019-11-07 14:31:46','2019-11-07 14:31:46'),
	(422,'fpDm','发票代码','Y','N',22,1,NULL,'2019-12-12 19:43:59','2019-12-12 19:43:59'),
	(423,'fpHm','发票号码','Y','N',22,2,NULL,'2019-12-12 19:43:59','2019-12-12 19:43:59'),
	(424,'kprq','开票日期','Y','N',22,3,NULL,'2019-12-12 19:43:59','2019-12-12 19:43:59'),
	(425,'xsfMc','销售方名称','Y','N',22,4,NULL,'2019-12-12 19:43:59','2019-12-12 19:43:59'),
	(426,'hjje','金额','Y','N',22,5,NULL,'2019-12-12 19:43:59','2019-12-12 19:43:59'),
	(427,'hjse','税额','Y','N',22,6,NULL,'2019-12-12 19:43:59','2019-12-12 19:43:59'),
	(428,'voucherid','凭证号','Y','N',22,7,NULL,'2019-12-12 19:43:59','2019-12-12 19:43:59'),
	(429,'exportRebates','进口退税','Y','N',1,34,NULL,'2019-12-12 19:43:59','2019-12-12 19:43:59'),
	(430,'accountCode','科目代码','Y','Y',23,1,NULL,'2019-12-12 19:47:52','2019-12-12 19:44:27'),
	(431,'accountName','科目名称','Y','Y',23,2,NULL,'2019-12-12 19:47:54','2019-12-12 19:44:27'),
	(432,'mapAccountCode',',对应科目代码','Y','Y',23,3,NULL,'2019-12-12 19:47:55','2019-12-12 19:44:27'),
	(433,'mapAccountName',',对应科目名称','Y','Y',23,4,NULL,'2019-12-12 19:47:56','2019-12-12 19:44:27'),
	(434,'orgName','组织','Y','Y',20,1,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(435,'outputIncome','销项,开具增值税发票,不含税收入','Y','Y',20,2,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(436,'outputTax','销项,开具增值税发票,税额','Y','Y',20,3,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(437,'outputNoInvoicedIncome','销项,未开票收入,不含税收入','Y','Y',20,4,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(438,'outputNoInvoicedTax','销项,未开票收入,税额','Y','Y',20,5,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(439,'outputTotalIncome','销项,合计,不含税收入合计','Y','Y',20,6,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(440,'outputTotalTax','销项,合计,税额合计','Y','Y',20,7,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(441,'outputTotalAmount','销项,合计,价税合计','Y','Y',20,8,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(442,'subInitial','分包,期初留抵','Y','Y',20,9,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(443,'subTotalAmount','分包,分包发生额','Y','Y',20,10,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(444,'subAdjustiveNum','分包,调整数','Y','Y',20,11,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(445,'subRealTotalAmount','分包,实际抵扣分包含税金额','Y','Y',20,12,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(446,'subRealTax','分包,实际抵扣分包税额','Y','Y',20,13,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(447,'subLastAmount','分包,期未留抵数','Y','Y',20,14,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(448,'inputInitial','进项,期初留抵','Y','Y',20,15,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(449,'inputCheckedTotalAmount','进项,进项税额（已认证）','Y','Y',20,16,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(450,'inputUncheckTotalAmount','进项,进项税额（未认证）','Y','Y',20,17,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(451,'inputDeductibleTotalAmount','进项,进项税额（计算抵扣）','Y','Y',20,18,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(452,'inputAdjustiveNum','进项,进项调整','Y','Y',20,19,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(453,'inputRealCheckedTotalAmount','进项,实际勾选抵扣进项税额','Y','Y',20,20,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(454,'inputRealDeductibleTotalAmount','进项,实际计算抵扣进项税额','Y','Y',20,21,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(455,'inputLastAmount','进项,进项留抵','Y','Y',20,22,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(456,'transferOut','进项转出','Y','Y',20,23,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(457,'prepayInitial','预交,期初留抵','Y','Y',20,24,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(458,'prepayAmount','预交,预交发生数','Y','Y',20,25,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(459,'prepayAdjustiveNum','预交,调整数','Y','Y',20,26,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(460,'prepayRealAmount','预交,实际预交数','Y','Y',20,27,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(461,'prepayLastAmount','预交,期末留抵','Y','Y',20,28,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(462,'deductionTax','减免增值税','Y','Y',20,29,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(463,'payableTax','应纳增值税','Y','Y',20,30,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(464,'payingTax','已交增值税','Y','Y',20,31,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(465,'orgName','组织','Y','Y',21,1,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(466,'projectName','项目名称','Y','Y',21,2,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(467,'outputIncome','销项,开具增值税发票,不含税收入','Y','Y',21,3,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(468,'outputTax','销项,开具增值税发票,税额','Y','Y',21,4,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(469,'outputNoInvoicedIncome','销项,未开票收入,不含税收入','Y','Y',21,5,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(470,'outputNoInvoicedTax','销项,未开票收入,税额','Y','Y',21,6,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(471,'outputTotalIncome','销项,合计,不含税收入合计','Y','Y',21,7,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(472,'outputTotalTax','销项,合计,税额合计','Y','Y',21,8,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(473,'outputTotalAmount','销项,合计,价税合计','Y','Y',21,9,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(474,'subInitial','分包,期初留抵','Y','Y',21,10,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(475,'subTotalAmount','分包,分包发生额','Y','Y',21,11,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(476,'subAdjustiveNum','分包,调整数','Y','Y',21,12,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(477,'subRealTotalAmount','分包,实际抵扣分包含税金额','Y','Y',21,13,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(478,'subRealTax','分包,实际抵扣分包税额','Y','Y',21,14,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(479,'subLastAmount','分包,期未留抵数','Y','Y',21,15,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(480,'inputInitial','进项,期初留抵','Y','Y',21,16,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(481,'inputCheckedTotalAmount','进项,进项税额（已认证）','Y','Y',21,17,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(482,'inputUncheckTotalAmount','进项,进项税额（未认证）','Y','Y',21,18,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(483,'inputDeductibleTotalAmount','进项,进项税额（计算抵扣）','Y','Y',21,19,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(484,'inputAdjustiveNum','进项,进项调整','Y','Y',21,20,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(485,'inputRealCheckedTotalAmount','进项,实际勾选抵扣进项税额','Y','Y',21,21,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(486,'inputRealDeductibleTotalAmount','进项,实际计算抵扣进项税额','Y','Y',21,22,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(487,'inputLastAmount','进项,进项留抵','Y','Y',21,23,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(488,'transferOut','进项转出','Y','Y',21,24,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(489,'prepayInitial','预交,期初留抵','Y','Y',21,25,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(490,'prepayAmount','预交,预交发生数','Y','Y',21,26,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(491,'prepayAdjustiveNum','预交,调整数','Y','Y',21,27,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(492,'prepayRealAmount','预交,实际预交数','Y','Y',21,28,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(493,'prepayLastAmount','预交,期末留抵','Y','Y',21,29,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(494,'deductionTax','减免增值税','Y','Y',21,30,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(495,'payableTax','应纳增值税','Y','Y',21,31,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(496,'payingTax','已交增值税','Y','Y',21,32,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(497,'nsrmc','纳税人名称','Y','Y',25,1,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(498,'orgName','组织名称','Y','Y',25,2,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(499,'realSaleAmount','实际销售额','Y','Y',25,3,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(500,'outputTax','销项税额','Y','Y',25,4,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(501,'inputTax','进项税额','Y','Y',25,5,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(502,'transferOut','进项转出','Y','Y',25,6,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(503,'prepayTax','预交税额','Y','Y',25,7,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(504,'deductionTax','减免税额','Y','Y',25,8,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(505,'payableTax','应交增值税金','Y','Y',25,9,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(506,'lastAmount','期末留抵','Y','Y',25,10,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(507,'taxBearingRate','税负率','Y','Y',25,11,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(508,'industryTaxBearingRate','行业税负率','Y','Y',25,12,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(509,'nsrmc','纳税人名称','Y','Y',27,1,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(510,'orgName','组织名称','Y','Y',27,2,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(511,'accountOrgName','核算单位','Y','Y',27,3,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(512,'realSaleAmount','实际销售额','Y','Y',27,4,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(513,'outputTax','销项税额','Y','Y',27,5,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(514,'inputTax','进项税额','Y','Y',27,6,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(515,'transferOut','进项转出','Y','Y',27,7,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(516,'prepayTax','预交税额','Y','Y',27,8,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(517,'deductionTax','减免税额','Y','Y',27,9,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(518,'payableTax','应交增值税金','Y','Y',27,10,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(519,'lastAmount','期末留抵','Y','Y',27,11,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(520,'taxBearingRate','税负率','Y','Y',27,12,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(521,'industryTaxBearingRate','行业税负率','Y','Y',27,13,NULL,'2019-12-12 19:44:27','2019-12-12 19:44:27'),
	(522,'nsrsbh','税号','Y','Y',26,1,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(523,'nsrmc','纳税人名称','Y','Y',26,2,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(524,'orgName','组织名称','Y','Y',26,3,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(525,'projectName','项目名称','N','Y',26,4,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(526,'period','预交所属期','Y','Y',26,5,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(527,'taxMethod','计税方式','Y','Y',26,6,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(528,'totalContractAmount','合同金额','Y','Y',26,7,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(529,'amount','开票金额','Y','Y',26,8,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(530,'deduction','扣除额','Y','Y',26,9,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(531,'totalSe','预征税额','Y','Y',26,10,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(532,'prepayPath','缴款书','Y','Y',26,11,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(533,'vatTax','增值税预交税率','N','N',26,12,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(534,'vatAmount','已预缴增值税税额','N','N',26,13,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(535,'urbanTax','城建税预交税率','N','N',26,14,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(536,'urbanAmount','已预缴城建税税额','N','N',26,15,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(537,'eduAttachTax','教育费附加预交税率','N','N',26,16,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(538,'eduAttachAmount','已预缴教育费附加税额','N','N',26,17,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(539,'localEduTax','地方教育附加预交税率','N','N',26,18,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(540,'localEduAmount','已预缴地方教育附加税额','N','N',26,19,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(541,'corpIncomeTax','企业所得税预交税率','N','N',26,20,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(542,'corpIncomeAmount','已预缴企业所得税税额','N','N',26,21,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(543,'stampTax','印花税预交税率','N','N',26,22,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(544,'stampAmount','已预缴印花税税额','N','N',26,23,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(545,'waterConservancyTax','水利建设基金预交税率','N','N',26,24,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(546,'waterConservancyAmount','已预缴水利建设基金税额','N','N',26,25,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(547,'personalTax','个人所得税预交税率','N','N',26,26,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(548,'personalAmount','已预缴个人所得税税额','N','N',26,27,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(549,'declareStatus','是否申报','N','N',26,28,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(550,'accountTime','记账日期','N','N',26,29,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(551,'voucherid','凭证号','N','N',26,30,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28'),
	(552,'declarePeriod','申报所属期','N','N',26,31,NULL,'2019-12-12 20:14:28','2019-12-12 20:14:28');

/*!40000 ALTER TABLE `globle_item_config` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_item_config
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_item_config`;

CREATE TABLE `user_item_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `busi_id` int(11) NOT NULL COMMENT '业务类型编码',
  `userid` varchar(64) DEFAULT NULL COMMENT '用户id',
  `field` varchar(30) DEFAULT NULL COMMENT '实体属性名',
  `column_zh` varchar(50) DEFAULT NULL COMMENT 'Excel列名',
  `benable` char(1) DEFAULT 'Y' COMMENT '是否可编辑',
  `checked` char(1) DEFAULT 'N' COMMENT '是否勾选',
  `sort` int(3) DEFAULT NULL COMMENT '字段排序',
  `processer` varchar(50) DEFAULT NULL COMMENT 'Excel字段格式处理类',
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_userid_busiid` (`userid`,`busi_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户导出项配置表';

/*message库*/
create database yt_piaoeda_message;

use yt_piaoeda_message;

DROP TABLE IF EXISTS `notify`;

CREATE TABLE `notify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `info_type` char(1) NOT NULL COMMENT '通知方式：1：通告，2：提醒，3：消息',
  `notify_type` char(1) DEFAULT NULL COMMENT '通知类型。1:进项风控预警,2:专票获取预警,3:空白票预警,4:Excel导出',
  `content` varchar(1000) DEFAULT NULL COMMENT '通知内容',
  `sender_id` varchar(64) DEFAULT NULL COMMENT '通知发送者',
  `corp_id` varchar(64) DEFAULT NULL COMMENT '公司id',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知表';



# Dump of table subscription
# ------------------------------------------------------------

DROP TABLE IF EXISTS `subscription`;

CREATE TABLE `subscription` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `notify_type` char(1) DEFAULT NULL COMMENT '通知类型。1:进项风控预警,2:专票获取预警,3:空白票预警,4:Excel导出',
  `channel` char(1) DEFAULT NULL COMMENT '订阅渠道：1:微信，2：邮箱，3：平台',
  `address` varchar(64) DEFAULT NULL COMMENT '订阅地址（微信号、邮箱地址、平台用户id）',
  `receiver_id` varchar(64) DEFAULT NULL COMMENT '通知接收者id',
  `submitter_id` varchar(64) DEFAULT NULL COMMENT '订阅发起人id',
  `corp_id` varchar(64) DEFAULT NULL COMMENT '公司id',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `submitter_corp` (`submitter_id`,`corp_id`),
  KEY `notify_corp` (`notify_type`,`corp_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订阅表';



# Dump of table user_notify
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_notify`;

CREATE TABLE `user_notify` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `notify_id` int(11) NOT NULL COMMENT '通知表主键',
  `receiver_id` varchar(64) DEFAULT NULL COMMENT '通知接收者id',
  `already_read` char(1) DEFAULT 'N' COMMENT '是否已读：Y:已读，N:未读',
  `channel` char(1) DEFAULT NULL COMMENT '订阅渠道：1:微信，2：邮箱，3：平台',
  `address` varchar(64) DEFAULT NULL COMMENT '订阅地址（微信号、邮箱地址、平台用户id）',
  `push_status` char(1) NOT NULL COMMENT '推送状态：1：未推送，2：推送成功，3. 推送失败',
  `reason` varchar(100) DEFAULT NULL COMMENT '失败原因',
  `corp_id` varchar(64) DEFAULT NULL COMMENT '公司id',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `notify_id` (`notify_id`) USING BTREE,
  KEY `receive_corp` (`receiver_id`,`corp_id`) USING BTREE,
  CONSTRAINT `notify_id` FOREIGN KEY (`notify_id`) REFERENCES `notify` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户通知表';

/*other-tax库*/
create database yt_piaoeda_other_tax;

use yt_piaoeda_other_tax;

DROP TABLE IF EXISTS `house_account`;

CREATE TABLE `house_account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` int(11) NOT NULL COMMENT '组织id',
  `code` varchar(50) NOT NULL COMMENT '房源编号（税局赋予唯一编号）',
  `name` varchar(50) DEFAULT NULL COMMENT '房产名称',
  `uses` tinyint(1) NOT NULL COMMENT '房产用途 1：工业 2:商业及办公 3:住房 4:其他',
  `tax_payer_type` tinyint(1) NOT NULL COMMENT '纳税人类型 1：产权所有人 2:经营管理人 3:承典人 4:房屋代管人 5:房屋使用人 6：融资租赁承租人',
  `owner_name` varchar(50) DEFAULT NULL COMMENT '所有权人名称',
  `owner_code` varchar(50) DEFAULT NULL COMMENT '所有权人识别号',
  `cert_num` varchar(50) DEFAULT NULL COMMENT '房产证书号',
  `obtain_time` date NOT NULL COMMENT '房产取得时间',
  `construction_area` varchar(16) NOT NULL COMMENT '建筑面积',
  `region` varchar(50) NOT NULL COMMENT '房屋行政区划',
  `street` varchar(50) NOT NULL COMMENT '房屋所处街道',
  `detail_addr` varchar(50) NOT NULL COMMENT '房屋详细地址',
  `tax_office` varchar(50) NOT NULL COMMENT '所属主管税务所',
  `land_num` varchar(50) DEFAULT NULL COMMENT '房屋所在土地编号',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房产台账';



# Dump of table house_rent
# ------------------------------------------------------------

DROP TABLE IF EXISTS `house_rent`;

CREATE TABLE `house_rent` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `house_id` int(11) unsigned NOT NULL COMMENT '房产台账主键',
  `rent_area` varchar(15) NOT NULL COMMENT '出租面积',
  `rent_total_income` decimal(15,2) NOT NULL COMMENT '合同租金总收入',
  `rent_begin` varchar(12) NOT NULL COMMENT '租赁期起',
  `rent_end` varchar(12) NOT NULL COMMENT '租赁期止',
  `tenantry_nsrsbh` varchar(20) DEFAULT NULL COMMENT '承租方纳税人识别号',
  `tenantry_name` varchar(50) DEFAULT NULL COMMENT '承租方名称',
  `declare_begin` varchar(12) DEFAULT NULL COMMENT '申报租金所属租赁期起',
  `declare_end` varchar(12) DEFAULT NULL COMMENT '申报租金所属租赁期止',
  `reduction_code` varchar(16) DEFAULT NULL COMMENT '减免性质代码',
  `reduction_tax_ori_value` decimal(15,2) DEFAULT NULL COMMENT '减免税原值',
  `reduction_rent_income` decimal(15,2) DEFAULT NULL COMMENT '减免租金收入',
  `month_reduction_tax_value` decimal(15,2) DEFAULT NULL COMMENT '月减免税金额',
  `indate_begin` varchar(12) DEFAULT NULL COMMENT '有效期起',
  `indate_end` varchar(12) DEFAULT NULL COMMENT '有效期止',
  `change_time` varchar(12) DEFAULT NULL COMMENT '变更时间',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房产从租纳税信息';



# Dump of table house_valorem
# ------------------------------------------------------------

DROP TABLE IF EXISTS `house_valorem`;

CREATE TABLE `house_valorem` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `house_id` int(11) unsigned NOT NULL COMMENT '房产台账主键',
  `original_value` decimal(15,2) NOT NULL COMMENT '房产原值',
  `rent_value` decimal(15,2) NOT NULL COMMENT '出租房产原值',
  `rent_area` varchar(15) NOT NULL COMMENT '出租房产面积',
  `rate_ratio` tinyint(1) NOT NULL COMMENT '计税比例 整数保存百分比',
  `tax_begin` varchar(12) NOT NULL COMMENT '纳税义务有效期起',
  `tax_end` varchar(12) DEFAULT NULL COMMENT '纳税义务有效期止',
  `reduction_code` varchar(16) DEFAULT NULL COMMENT '减免性质代码',
  `reduction_tax_ori_value` decimal(15,2) DEFAULT NULL COMMENT '减免税原值',
  `month_deduction_tax_value` decimal(15,2) DEFAULT NULL COMMENT '月减免税金额',
  `indate_begin` varchar(12) DEFAULT NULL COMMENT '有效期起',
  `indate_end` varchar(12) DEFAULT NULL COMMENT '有效期止',
  `change_time` varchar(12) DEFAULT NULL COMMENT '变更时间',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房产从价纳税信息';



# Dump of table land_holding_tax
# ------------------------------------------------------------

DROP TABLE IF EXISTS `land_holding_tax`;

CREATE TABLE `land_holding_tax` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corpid` varchar(64) NOT NULL COMMENT '集团ID',
  `orgid` int(11) NOT NULL COMMENT '组织ID',
  `land_number` varchar(50) NOT NULL COMMENT '土地编号',
  `tax_payer_type` tinyint(1) NOT NULL COMMENT '纳税人类型；1-权属所有人；2-集体土地使用人；3-无偿使用人；4-代管人；5-实际使用人；',
  `tax_payer_nsrsbh` varchar(50) DEFAULT NULL COMMENT '土地使用权人识别号',
  `tax_payer_name` varchar(100) DEFAULT NULL COMMENT '土地使用权人名称',
  `land_cert_number` varchar(50) DEFAULT NULL COMMENT '土地使用证号',
  `land_sn` varchar(50) DEFAULT NULL COMMENT '地号（丘号）',
  `land_name` varchar(50) DEFAULT NULL COMMENT '土地名称',
  `land_obtain_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '土地获取时间',
  `land_obtain_method` tinyint(1) DEFAULT NULL COMMENT '土地获得方式；1-划拨，2-出让，3-租赁，4-转让，5-其他',
  `land_area` decimal(15,2) DEFAULT NULL COMMENT '土地面积',
  `land_type` tinyint(1) DEFAULT NULL COMMENT '土地性质；1-国有，2-集体',
  `land_uses` tinyint(1) DEFAULT NULL COMMENT '土地用途;1-商业用地，2-综合用地，3-住宅用地，4-工业用地，5-房地产开发企业的开发用地，6-其他用地',
  `land_price` decimal(15,2) DEFAULT NULL COMMENT '土地价格',
  `payment_amount` decimal(15,2) DEFAULT NULL COMMENT '取得土地使用权支付的金额',
  `land_cost` decimal(15,2) DEFAULT NULL COMMENT '土地开发成本',
  `division` varchar(50) DEFAULT NULL COMMENT '土地行政区划',
  `street` varchar(50) DEFAULT NULL COMMENT '所处街道',
  `land_address` varchar(50) DEFAULT NULL COMMENT '土地详细地址',
  `tax_office` varchar(50) DEFAULT NULL COMMENT '所属主管税务所',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '登记时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_land_number` (`land_number`) USING BTREE COMMENT '土地编号唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='土地持有税';



# Dump of table land_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `land_info`;

CREATE TABLE `land_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `land_tax_id` int(10) unsigned NOT NULL COMMENT '土地使用税id',
  `land_level` varchar(30) DEFAULT NULL COMMENT '土地等级',
  `land_price` decimal(15,2) DEFAULT NULL COMMENT '税额标准',
  `land_tax_area` decimal(15,2) DEFAULT NULL COMMENT '应税土地面积',
  `change_time` datetime DEFAULT NULL COMMENT '变更时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '登记时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_land_tax_id` (`land_tax_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='土地信息';



# Dump of table land_tax_period
# ------------------------------------------------------------

DROP TABLE IF EXISTS `land_tax_period`;

CREATE TABLE `land_tax_period` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `land_tax_id` int(11) unsigned NOT NULL COMMENT '土地使用税id',
  `effective_date` datetime DEFAULT NULL COMMENT '生效日期',
  `expiration_date` datetime DEFAULT NULL COMMENT '失效日期',
  `change_time` datetime DEFAULT NULL COMMENT '变更时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_land_tax_id` (`land_tax_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='纳税义务起止日期';



# Dump of table land_tax_reduce
# ------------------------------------------------------------

DROP TABLE IF EXISTS `land_tax_reduce`;

CREATE TABLE `land_tax_reduce` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `land_tax_id` int(10) unsigned NOT NULL,
  `reduce_code` varchar(50) DEFAULT NULL COMMENT '减免性质代码',
  `reduce_area` varchar(50) DEFAULT NULL COMMENT '减免面积',
  `reduce_money` decimal(15,2) DEFAULT NULL COMMENT '月减免金额',
  `effective_date` datetime DEFAULT NULL COMMENT '生效日期',
  `expiration_date` datetime DEFAULT NULL COMMENT '失效日期',
  `change_time` datetime DEFAULT NULL COMMENT '变更时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_land_tax_id` (`land_tax_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='减免税信息';



# Dump of table stamp_tax_account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `stamp_tax_account`;

CREATE TABLE `stamp_tax_account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `je` decimal(15,2) DEFAULT NULL COMMENT '计税金额或件数',
  `sl` decimal(6,5) DEFAULT NULL COMMENT '税率',
  `payable_tax` decimal(15,2) DEFAULT NULL COMMENT '本期应纳税额',
  `paid_tax` decimal(15,2) DEFAULT NULL COMMENT '本期已缴税额',
  `period` varchar(8) DEFAULT NULL COMMENT '税款所属期',
  `contract_detail_id` int(11) DEFAULT NULL COMMENT '合同明细主键',
  `prepay_tax_bureau` varchar(20) DEFAULT NULL COMMENT '预缴税务局',
  `voucher_type` char(2) DEFAULT NULL COMMENT '应税凭证类型',
  `contract_name` varchar(64) DEFAULT NULL COMMENT '账簿/证照名称',
  `iscontract` char(1) DEFAULT NULL COMMENT '是否合同类',
  `remote_pay` char(1) DEFAULT 'N' COMMENT '是否异地缴纳印花税',
  `corpid` varchar(64) NOT NULL COMMENT '公司id',
  `orgid` varchar(36) NOT NULL COMMENT '组织id',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='印花税台账';

/* report库 */
create database yt_piaoeda_report;

use yt_piaoeda_report;

DROP TABLE IF EXISTS `tax_cube`;

CREATE TABLE `tax_cube` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corp_id` varchar(64) DEFAULT NULL COMMENT '企业id',
  `cube_code` varchar(30) NOT NULL COMMENT '模型编码',
  `cube_name` varchar(30) NOT NULL COMMENT '模型名称',
  `table` varchar(30) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `report_cube_cube_code_uindex` (`cube_code`),
  UNIQUE KEY `tax_cube_cube_name_uindex` (`cube_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模型信息表';



# Dump of table tax_cube_dim
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tax_cube_dim`;

CREATE TABLE `tax_cube_dim` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corp_id` varchar(64) DEFAULT NULL COMMENT '企业id',
  `cube_id` int(11) unsigned NOT NULL COMMENT '模型id',
  `dim_id` int(11) unsigned NOT NULL COMMENT '维度id',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模型-维度 关系表';



# Dump of table tax_dimension
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tax_dimension`;

CREATE TABLE `tax_dimension` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corp_id` varchar(64) DEFAULT NULL,
  `dim_code` varchar(30) NOT NULL COMMENT '维度编码',
  `dim_name` varchar(30) NOT NULL COMMENT '维度名称',
  `dim_type` varchar(30) NOT NULL COMMENT '维度字段类型',
  `table` varchar(30) DEFAULT NULL COMMENT '维度表表名',
  `tree_type` int(5) unsigned NOT NULL DEFAULT '0' COMMENT '维度成员树类型 0：非树形，列表型 1：父子树 2：编码树 3: 度量值',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tax_dimension_dim_code_uindex` (`dim_code`),
  UNIQUE KEY `tax_dimension_dim_name_uindex` (`dim_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维度信息表';



# Dump of table tax_dimension_nsrsbh
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tax_dimension_nsrsbh`;

CREATE TABLE `tax_dimension_nsrsbh` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corp_id` varchar(64) DEFAULT NULL COMMENT '企业id',
  `code` varchar(30) NOT NULL COMMENT '税号编码',
  `name` varchar(30) DEFAULT NULL COMMENT '税号',
  `nsrmc` varchar(30) DEFAULT NULL COMMENT '纳税人名称',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dimension_nsrsbh_code_uindex` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维度表-纳税人识别号';



# Dump of table tax_dimension_project
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tax_dimension_project`;

CREATE TABLE `tax_dimension_project` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corp_id` varchar(64) DEFAULT NULL COMMENT '企业id',
  `pid` int(11) unsigned NOT NULL COMMENT '父id',
  `code` varchar(30) NOT NULL COMMENT '项目编码',
  `name` varchar(30) DEFAULT NULL COMMENT '项目名称',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dimension_project_code_uindex` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维度表-项目';



# Dump of table tax_dimension_reportproject
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tax_dimension_reportproject`;

CREATE TABLE `tax_dimension_reportproject` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corp_id` varchar(64) DEFAULT NULL,
  `pid` int(11) unsigned NOT NULL COMMENT '父id',
  `code` varchar(30) NOT NULL COMMENT '报表项目编码',
  `name` varchar(100) NOT NULL COMMENT '报表项目名称',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dimension_report_project_code_uindex` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维度表-报表项目';



# Dump of table tax_dimension_structure
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tax_dimension_structure`;

CREATE TABLE `tax_dimension_structure` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corp_id` varchar(64) DEFAULT NULL,
  `dim_id` int(11) unsigned NOT NULL COMMENT '所属维度id',
  `structure_code` varchar(30) NOT NULL COMMENT '维度表列编码',
  `structure_name` varchar(30) NOT NULL COMMENT '维度表列名称',
  `structure_type` varchar(30) NOT NULL COMMENT '维度表列类型',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维度结构表';



# Dump of table tax_dimension_year
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tax_dimension_year`;

CREATE TABLE `tax_dimension_year` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corp_id` varchar(64) DEFAULT NULL,
  `code` varchar(30) NOT NULL COMMENT '编码',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `dimension_year_code_uindex` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维度表-年';



# Dump of table tax_income_settlement_model
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tax_income_settlement_model`;

CREATE TABLE `tax_income_settlement_model` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `corp_id` varchar(64) DEFAULT NULL COMMENT '企业id',
  `nsrsbh` varchar(11) NOT NULL COMMENT '纳税人识别号',
  `project` varchar(11) NOT NULL COMMENT '项目编码',
  `report_project` varchar(11) DEFAULT NULL COMMENT '报表项目',
  `year` varchar(11) DEFAULT NULL COMMENT '年',
  `vdefault` varchar(30) NOT NULL COMMENT '数值',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ts` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业所得税事实表';
