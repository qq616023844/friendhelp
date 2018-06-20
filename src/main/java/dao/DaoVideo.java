package dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import entity.Danmaku;
import entity.Video;

public interface DaoVideo {
	public Video getDetailVideo(String video_id);
	public List<Danmaku> getDanmaku(String video_id,long date_start,long date_end);
	public boolean sendDanmaku(Danmaku danmaku);
}
