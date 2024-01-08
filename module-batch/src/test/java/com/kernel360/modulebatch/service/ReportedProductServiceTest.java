package com.kernel360.modulebatch.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kernel360.ecolife.entity.ReportedProduct;
import com.kernel360.ecolife.repository.ReportedProductRepository;
import com.kernel360.modulebatch.dto.ReportedProductDto;
import com.kernel360.modulebatch.dto.ReportedProductListDto;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
class ReportedProductServiceTest {
    // 요청은 한번만 보내고 재활용하도록 리팩터링 필요
    @MockBean
    private ReportedProductRepository repository;
    private ReportedProductService service;

    private String testXml;

    @BeforeEach
    void setUp() {
        service = new ReportedProductService(repository);
        testXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<rows>\n"
                + "\t<count>371631</count>\n"
                + "\t<resultcode>0000</resultcode>\n"
                + "\t<pagenum>8</pagenum>\n"
                + "\t<pagesize>20</pagesize>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_2A2CC0184]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[올센느 룸스프레이 그리너리 토마토]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[FB21-13-0006]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[탈취제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[56]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[주식회사 고리/ODM]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_A4F3FD033]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[벨벨 리필오일(블랙체리)]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[EB23-12-2774]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[방향제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[4]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[벨벨 BellBell/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_A4F3FD033]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[벨벨 리필오일(판타지)]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[EB23-12-2774]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[방향제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[2]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[벨벨 BellBell/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_761BEF70B]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[바이오미스트 아로마 인테리어 (레몬 샤워)]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[HB21-12-0243]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[방향제,탈취제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[211]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[(주)바이오미스트테크놀로지/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_761BEF70B]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[바이오미스트 아로마 인테리어 (프렌치 페퍼민트)]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[HB21-12-0243]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[방향제,탈취제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[210]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[(주)바이오미스트테크놀로지/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_761BEF70B]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[바이오미스트 아로마 인테리어 (프렌치 라벤더)]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[HB21-12-0243]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[방향제,탈취제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[209]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[(주)바이오미스트테크놀로지/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_3628A116E]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[에이치위드 소이캔들(플루메리아)]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[HB23-26-1425]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[초]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[10]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[에이치위드(H.with)/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_3628A116E]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[에이치위드 소이캔들(메리미)]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[HB23-26-1425]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[초]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[9]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[에이치위드(H.with)/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_2F3FEEB08]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[패브릭마카 그린]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[CB22-14-0030]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[물체 염색제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[28]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[주식회사 다운포스/]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_2F3FEEB08]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[패브릭마카 오렌지]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[CB22-14-0030]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[물체 염색제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[26]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[주식회사 다운포스/]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_2F3FEEB08]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[패브릭마카 마젠타]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[CB22-14-0030]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[물체 염색제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[24]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[주식회사 다운포스/]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_9227D40AD]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[메르헨트 스카치 레드엔젤 디퓨저 헤리티지 위스키]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[CB23-12-1972]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[방향제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[15]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[오가닉K/ODM]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_81AF11F6A]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[에이쿠(A-COO)석고방향제-한라산의향]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[EB23-12-0063]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[방향제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[14]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[에이쿠(A-COO)/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_81AF11F6A]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[에이쿠(A-COO)석고방향제-라튤립]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[EB23-12-0063]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[방향제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[13]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[에이쿠(A-COO)/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_CD1F4F841]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[아도라블 소이캔들(가든스윗티)]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[CB23-26-1304]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[초]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[7]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[아도라블캔들/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_7AF726156]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[셀라문소이-플라워샵]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[DB20-26-0976]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[초]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[217]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[셀라문(cellardoor)/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_612C71575]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[데일리콤마 디퓨저 화이트머스크]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[HB20-12-1861]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[방향제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[400]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[에이디인터내셔날(주)/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_12A2ACF6B]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[블루엣 디퓨저(테싯)]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[CB23-12-2748]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[방향제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[23]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[블루엣(bluette)/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_A4F3FD033]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[벨벨 리필오일(에끌라드아르페쥬)]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[EB23-12-2774]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[방향제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[3]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[벨벨 BellBell/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "\t<row>\n"
                + "\t\t<mst_id>\n"
                + "\t\t\t<![CDATA[NLC_12A2ACF6B]]>\n"
                + "\t\t</mst_id>\n"
                + "\t\t<prdt_nm>\n"
                + "\t\t\t<![CDATA[블루엣 디퓨저(머스크)]]>\n"
                + "\t\t</prdt_nm>\n"
                + "\t\t<slfsfcfst_no>\n"
                + "\t\t\t<![CDATA[CB23-12-2748]]>\n"
                + "\t\t</slfsfcfst_no>\n"
                + "\t\t<item>\n"
                + "\t\t\t<![CDATA[방향제]]>\n"
                + "\t\t</item>\n"
                + "\t\t<est_no>\n"
                + "\t\t\t<![CDATA[20]]>\n"
                + "\t\t</est_no>\n"
                + "\t\t<reg_date>\n"
                + "\t\t\t<![CDATA[20240104]]>\n"
                + "\t\t</reg_date>\n"
                + "\t\t<comp_nm>\n"
                + "\t\t\t<![CDATA[블루엣(bluette)/직접생산]]>\n"
                + "\t\t</comp_nm>\n"
                + "\t</row>\n"
                + "</rows>";
    }

    @Test
    @DisplayName("신고대상 생활화학제품 목록 요청에서 전체 페이지 수를 반환하는 데 성공한다")
    void 응답의_생활화학제품목록의_전체_제품_개수를_통해_탐색해야할_전체_페이지_수를_반환_테스트() throws JsonProcessingException {
        int totalPageCount = service.getTotalPageCount(testXml);

        assertThat(totalPageCount).isGreaterThan(-1);
    }

    @Test
    @Transactional
    @DisplayName("신고대상 생활화학제품을 테이블에 저장하는 것에 성공한다")
    void 생활화학제품을_테이블에_저장_테스트() {
        // given
        ReportedProductDto testReportedProductDto = ReportedProductDto.of("masterId",
                "테스트이름",
                "테스트신고번호",
                "테스트제품분류",
                777,
                "20240103",
                "테스트회사이름");

        ReportedProduct mockProduct = ReportedProductDto.toEntity(testReportedProductDto);

        // set mocking behaviour
        // return the product when save() is invoked
        when(repository.save(any(ReportedProduct.class))).thenReturn(mockProduct);

        // set mock behavior for findByProductMasterId
        // when called with the same id, return the same product
        when(repository.findByProductMasterId(mockProduct.getProductMasterId()))
                .thenReturn(Optional.of(mockProduct));

        // when
        service.saveReportedProduct(testReportedProductDto);
        ReportedProduct foundReportedProduct = repository.findByProductMasterId(
                mockProduct.getProductMasterId()).orElseThrow();

        // then
        assertThat(foundReportedProduct).isNotNull();
        assertThat(foundReportedProduct.getProductMasterId())
                .isEqualTo(mockProduct.getProductMasterId());
    }


    @Test
    @DisplayName("신고대상 생활화학제품 목록을 파싱하는데 성공한댜")
    void 생활화학제품목록의_Dto_반환에_성공한다() throws JsonProcessingException {
        ReportedProductListDto dtoList = service.deserializeXml2ListDto(testXml);

        assertThat(dtoList).isNotNull();
        assertThat(dtoList.count()).isGreaterThan(0);
    }

    @Test
    @DisplayName("신고대상 생활화학 제품 목록안의 생활화학 제품을 파싱하는데 성공한다.")
    void 생활화학제품의_Dto_리스트_반환에_성공한다() throws JsonProcessingException {
        List<ReportedProductDto> dtoList = service.deserializeXml2ListDto(testXml)
                                                  .reportedProductDtoList();

        assertThat(dtoList).isNotNull();
        assertThat(dtoList.get(0).productMasterId()).isNotNull();
        assertThat(dtoList.get(0).estNumber()).isNotNull().isGreaterThan(-1);
    }
}