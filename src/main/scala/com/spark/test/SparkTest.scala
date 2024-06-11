package com.spark.test

import org.apache.spark.sql.SparkSession

object SparkTest {
  def main(args: Array[String]): Unit = {
    
    val a ="hdfs://hive_table_path/bpc_cnsldtn_trsn/000000_0"
    val b ="hdfs://hive_table_path/bpc_cnsldtn_trsn"
    val propertiesFilePath = String.valueOf(a.trim())
    var objectName         = propertiesFilePath.substring(propertiesFilePath.lastIndexOf("/") +1)
    var fileBasePath       = String.valueOf(b.trim())
    
    println(propertiesFilePath.lastIndexOf("/") + "\n" + propertiesFilePath + "\n" + objectName + "\n" + fileBasePath)
    
//    val spark =
//      SparkSession.builder()
//        .appName("DataFrame-Basic")
//        .master("local[4]")
//        .getOrCreate()
//        
//        spark.sql("select gnlr_ldgr_fact.entrs_lgl_ent_ldgr_cdascomp_code, substring(gnlr_ldgr_fact.grp_acct_nr,7,4)asgroup_acc, gnlr_ldgr_fact.pft_cntr_cdasprofit_center, gnlr_ldgr_fact.mgmt_grphy_unt_cdassegment, nvl(gnlr_ldgr_fact.fnctl_ar_cd,'')asfun_area, nvl(gnlr_ldgr_fact.cst_cntr_cd,'')ascost_center, gnlr_ldgr_fact.fscl_yr_nrasfiscal_year, gnlr_ldgr_fact.pstg_prd_nrasposting_period, gnlr_ldgr_fact.tc_cdastc_curr_cd, round(sum(gnlr_ldgr_fact.tc_amt),2)astc_curr_amt, round(sum(gnlr_ldgr_fact.gbl_curr_amt),2)asglobal_curr_amt from ea_fin.gnlr_ldgr_fact where gnrl_ldgr_acctng_cd='0L' andyr_nr=2020 andprd_nrbetween01and07 groupby gnlr_ldgr_fact.entrs_lgl_ent_ldgr_cd, substring(gnlr_ldgr_fact.grp_acct_nr,7,4), gnlr_ldgr_fact.pft_cntr_cd, gnlr_ldgr_fact.mgmt_grphy_unt_cd, nvl(gnlr_ldgr_fact.fnctl_ar_cd,''), nvl(gnlr_ldgr_fact.cst_cntr_cd,''), gnlr_ldgr_fact.fscl_yr_nr, gnlr_ldgr_fact.pstg_prd_nr, gnlr_ldgr_fact.tc_cd limit 10;")
  }
}