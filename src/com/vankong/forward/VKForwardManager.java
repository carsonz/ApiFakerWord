package com.vankong.forward;

import com.vankong.forward.bankcard.CustomBankCardListApi;
import com.vankong.forward.bankcardsyn.CustomBankCardSynApi;
import com.vankong.forward.bankcardsyn.BankCardCodeValueApi;
import com.vankong.forward.login.authenticate;
import com.vankong.forward.customer.*;
import com.vankong.utils.VKHttpAbstract;

/**
 * @项目名称：ApiFakerWord
 * @类名称：VKForwardManager
 * @创建人：cailiang
 * @创建时间：16/9/22 16:02
 * @修改人：
 * @修改时间：16/9/22 16:02
 * @修改备注：
 */
public class VKForwardManager {
    private static VKForwardManager mGlobalForward = null;
    public static VKForwardManager getManager()
    {
        if (mGlobalForward == null){
            mGlobalForward = new VKForwardManager();
        }
        return mGlobalForward;
    }
    public VKHttpAbstract getApiHook(String api)
    {
        VKHttpAbstract ab = null;
        if (api.contains("userSignOn.do")){
            ab = new authenticate();
        }else if(api.contains("customerslistAction.do")){
            ab = new Customerapi();
        }else if(api.contains("updateCustBankcardData4kcoll") || api.contains("addCustBankcardData4kcoll")){
            ab = new CustomBankCardListApi();
        }else if(api.contains("queryOpenAccountBankListAction")){
            ab = new BankCardCodeValueApi();
        }else if(api.contains("getCustBankcardData")){
            ab = new CustomBankCardSynApi();
        }
        return ab;
    }
}
