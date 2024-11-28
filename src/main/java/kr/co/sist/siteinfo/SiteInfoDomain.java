package kr.co.sist.siteinfo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SiteInfoDomain {

	private String protocol, server_name, context_root, site_name_kor, site_name_eng, upload_dir;

}
