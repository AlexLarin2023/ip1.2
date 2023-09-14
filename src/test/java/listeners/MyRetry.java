package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class MyRetry implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 3; //здесь я ставлю сколько попыток я хочу повторить

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
//я говорю попробуем максимально 3 раза если  он все
//3 раза упал значит это bug, но если вам хоть один раз из 3 не упал
//значит все нормально