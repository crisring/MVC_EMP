package kr.co.sist.siteinfo;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import lombok.Getter;

public class SiteInfo {

	private static SiteInfo si;

	@Getter
	private SiteInfoDomain siDomain;

	@Getter
	private String protocol, server_name, context_root, site_name_kor, site_name_eng;

	private SiteInfo() {

	}

	public static SiteInfo getInstance() {
		if (si == null) {
			si = new SiteInfo();
		}
		si.searchSiteInfo("D");
		return si;
	}// getInstance

	private void searchSiteInfo(String env) {
		MyBatisHandler mbh = MyBatisHandler.getInstance();

		SqlSession handler = mbh.getHandler();

		try {
			siDomain = handler.selectOne("selectSiteInfo", env);

		} finally {
			mbh.closeHandler(handler);
		}

	}// searchSiteInfo

}
