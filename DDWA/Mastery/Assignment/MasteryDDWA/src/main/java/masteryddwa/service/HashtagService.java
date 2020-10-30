/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package masteryddwa.service;

import java.util.ArrayList;
import java.util.List;
import masteryddwa.dao.HashtagDao;
import masteryddwa.dto.Hashtag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HashtagService {

    @Autowired
    private HashtagDao hashtagDao;

    public List<Hashtag> getHashtags(String hashtags) {
        String[] tags = hashtags.split(" ");
        List<Hashtag> hash = new ArrayList<>();
        
        for (String s: tags) {
            s.replace("#", "");
            s.replace(",", "");
            Hashtag h = new Hashtag();
            h.setTag(s);
            try {
                h = hashtagDao.addHashtag(h);
            } catch (Exception ex) {
                h = hashtagDao.getAllHashtagByTag(s);
            }
            
            hash.add(h);
        }
        
        return hash;
    }
    
    
}
