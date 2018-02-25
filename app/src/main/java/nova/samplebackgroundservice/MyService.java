package nova.samplebackgroundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

/**
 * Created by Administrator on 2018-02-21.
 */

// 서비스 클래스를 구현하려면, Service 를 상속받는다
public class MyService extends Service {
    // 외부로 데이터를 전달하려면 바인더 사용

    // Binder 객체는 IBinder 인터페이스 상속구현 객체입니다
    //public class Binder extends Object implements IBinder

    IBinder mBinder = new MyBinder();

    class MyBinder extends Binder {
        MyService getService() { // 서비스 객체를 리턴
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // 액티비티에서 bindService() 를 실행하면 호출됨
        // 리턴한 IBinder 객체는 서비스와 클라이언트 사이의 인터페이스 정의한다
        return mBinder; // 서비스 객체를 리턴
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    int getRan() { // 임의 랜덤값을 리턴하는 메서드
        return new Random().nextInt();
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}


