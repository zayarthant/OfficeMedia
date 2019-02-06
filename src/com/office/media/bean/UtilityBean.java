package com.office.media.bean;

import java.io.File;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import com.office.media.util.DateTimeUtil;
import com.office.media.util.ImageUtil;

@ManagedBean
@RequestScoped
public class UtilityBean {

	public String formatDayMonth(Date date) {
		return DateTimeUtil.formatDayMonth(date);
	}

	public String timeAgoFrom(Date date) {
		return DateTimeUtil.timeAgoFrom(date);
	}

	public String formatDate(Date date) {
		return DateTimeUtil.formatDayMonthYear(date);
	}

	public String uploadFile(Part image, String resource) {
		if (null == image)
			return null;
		String fileUrl = ImageUtil.generateImageName(image.getSubmittedFileName());
		String fullFileUrl = getFullFileUrl("/resources/images", fileUrl);
		ImageUtil.uploadImage(image, fullFileUrl);
		return fileUrl;
	}

	public String getFullFileUrl(String resource, String fileUrl) {
		return FacesContext.getCurrentInstance().getExternalContext().getRealPath(resource) + File.separator + fileUrl;
	}

}
