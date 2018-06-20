package service;

public interface ServiceUser {
	public String login(String content);
	public String loginByQQ(String content);
	public String register(String content);
	public String registerCheck(String content);
	public String registerCheckend(String content);
	public String registerCheckendByQQ(String content);
}
