package mes.service.bm;

import java.util.List;

import mes.domain.bm.GoodsCodeAdmVo;

public interface GoodsCodeAdmService {
	
	//제품코드 목록조회
	public List<GoodsCodeAdmVo> listAll() throws Exception;

	//제품코드 상세조회
	public GoodsCodeAdmVo read(GoodsCodeAdmVo goodsCodeAdmVo) throws Exception;
	
	//제품코드 등록
	public void create(GoodsCodeAdmVo goodsCodeAdmVo) throws Exception;
	
	//제품코드 수정
	public void update(GoodsCodeAdmVo goodsCodeAdmVo) throws Exception;	
	
	//제품코드 코드시퀀스조회
	public String selectGoodsSeqCd() throws Exception;		
}
