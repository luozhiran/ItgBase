# ItgBase
> 1. 对保存在handler中的activity进行弱引用
```
  public class MainActivity extends ItgHandlerActivity {
    
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void handleMessage(Message msg) {
        
    }
}
```
