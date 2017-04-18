package me.zoro.peachgardenmall.datasource;

import android.support.annotation.NonNull;

import java.util.List;
import java.util.Map;

import me.zoro.peachgardenmall.datasource.domain.Goods;

/**
 * Created by dengfengdecao on 17/4/17.
 */

public class GoodsRepository implements GoodsDatasource {

    private static GoodsRepository sRepository;

    private GoodsDatasource mRemoteDatasource;

    private GoodsRepository(GoodsDatasource remoteDatasource) {
        mRemoteDatasource = remoteDatasource;
    }

    public static GoodsRepository getInstance(GoodsDatasource remoteDatasource) {
        if (sRepository == null) {
            sRepository = new GoodsRepository(remoteDatasource);
        }

        return sRepository;
    }

    @Override
    public void getGoodses(Map<String, Object> params, @NonNull final GetGoodsesCallback callback) {
        mRemoteDatasource.getGoodses(params, new GetGoodsesCallback() {
            @Override
            public void onGoodsesLoaded(List<Goods> goodses) {
                callback.onGoodsesLoaded(goodses);
            }

            @Override
            public void onDataNotAvailable(String errorMsg) {
                callback.onDataNotAvailable(errorMsg);
            }
        });
    }
}