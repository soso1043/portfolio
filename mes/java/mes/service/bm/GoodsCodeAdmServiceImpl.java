package mes.service.bm;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import mes.domain.bm.GoodsCodeAdmVo;
import mes.persistence.bm.GoodsCodeAdmDAO;

@Service
public class GoodsCodeAdmServiceImpl implements GoodsCodeAdmService {

	@Inject
	private GoodsCodeAdmDAO dao;

	//제품코드 목록조회
	@Override
	public List<GoodsCodeAdmVo> listAll() throws Exception {
		return dao.listAll();
	}

	//제품코드 상세조회
	@Override
	public GoodsCodeAdmVo read(GoodsCodeAdmVo goodsCodeAdmVo) throws Exception {
		return dao.read(goodsCodeAdmVo);	
	}
	
	//제품코드 등록
	@Override
	public void create(GoodsCodeAdmVo goodsCodeAdmVo) throws Exception {
		dao.create(goodsCodeAdmVo);
	}
	
	//제품코드 수정
	@Override
	public void update(GoodsCodeAdmVo goodsCodeAdmVo) throws Exception {
		dao.update(goodsCodeAdmVo);
	}
	
	//제품코드 코드시퀀스조회
	@Override
	public String selectGoodsSeqCd() throws Exception{
		return dao.selectGoodsSeqCd();
	}
}

	