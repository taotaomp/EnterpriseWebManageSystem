package cn.PApudding.Beans;

/**
 * ��ҳý����Դʵ��
 * 
 * @author PApudding
 *
 */
public class WebMediaSource {
	private int id; // id
	private String mediaType; // ý������
	private String mediaName; // ý����
	private String mediaUrl; // ý���ַ
	private String mediaField; // ý��������

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
