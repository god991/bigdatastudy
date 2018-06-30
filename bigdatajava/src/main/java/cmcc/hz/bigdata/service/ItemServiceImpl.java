package cmcc.hz.bigdata.service;

import cmcc.hz.bigdata.dao.ItemDao;
import cmcc.hz.bigdata.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Product> itemSelectAll(int np) {
        return itemDao.itemSelectAll(np);
    }
}
