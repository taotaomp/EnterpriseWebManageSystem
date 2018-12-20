package cn.PApudding.Beans;

/**
 * 网页媒体资源实体
 * 
 * @author PApudding
 *
 */
public class WebMediaSource {
	private int id; // id
	private String mediaType; // 媒体类型
	private String mediaName; // 媒体名
	private String mediaUrl; // 媒体地址
	private String mediaField; // 媒体作用域

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public String getMediaField() {
		return mediaField;
	}

	public void setMediaField(String mediaField) {
		this.mediaField = mediaField;
	}
}
