package com.example.admin.lahacks2017;

import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Random;
import android.view.MenuItem;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {


    final String CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome";
    final String[] urls =
            {"https://en.wikipedia.org/wiki/List_of_Eiffel_Tower_replicas",
                    "https://en.wikipedia.org/wiki/Gravity_hill",
                    "https://en.wikipedia.org/wiki/List_of_tautological_place_names",
                    "https://en.wikipedia.org/wiki/Pizza_farm",
                    "https://en.wikipedia.org/wiki/Nail_house",
                    "https://en.wikipedia.org/wiki/Leaning_Tower_of_Suurhusen",
                    "https://en.wikipedia.org/wiki/Centralia,_Pennsylvania",
                    "https://en.wikipedia.org/wiki/Florence_Y%27all_Water_Tower",
                    "https://en.wikipedia.org/wiki/Michigan_left",
                    "https://en.wikipedia.org/wiki/Ragged_Ass_Road_(street)",
                    "https://en.wikipedia.org/wiki/Rough_and_Ready,_California",
                    "https://en.wikipedia.org/wiki/World%27s_littlest_skyscraper",
                    "https://en.wikipedia.org/wiki/Winchester_Mystery_House"
            };
    final String[] toastMessages =
            {
                    "Hope this helps!",
                    "Don't get too sucked in!",
                    "This article may be weird!",
                    "Is the other person gone yet?"
            };

            final String[] videos =
                    {
                            "https://www.youtube.com/watch?v=ktvTqknDobU",
                            "https://www.youtube.com/watch?v=CSvFpBOe8eY",
                            "https://www.youtube.com/watch?v=kXYiU_JCYtU",
                            "https://www.youtube.com/watch?v=mWRsgZuwf_8",
                            "https://www.youtube.com/watch?v=vx2u5uUu3DE" ,
                            "https://www.youtube.com/watch?v=nIjVuRTm-dc" ,
                            "https://www.youtube.com/watch?v=5anLPw0Efmo" ,
                            "https://www.youtube.com/watch?v=3YxaaGgTQYM" ,
                            "https://www.youtube.com/watch?v=YlUKcNNmywk" ,
                            "https://www.youtube.com/watch?v=kPBzTxZQG5Q" ,
                            "https://www.youtube.com/watch?v=fV4DiAyExN0" ,
                            "https://www.youtube.com/watch?v=1cQh1ccqu8M" ,
                            "https://www.youtube.com/watch?v=btPJPFnesV4" ,
                            "https://www.youtube.com/watch?v=JaAWdljhD5o" ,
                            "https://www.youtube.com/watch?v=gGdGFtwCNBE" ,
                            "https://www.youtube.com/watch?v=RF0HhrwIwp0" ,
                            "https://www.youtube.com/watch?v=u9Dg-g7t2l4" ,
                            "https://www.youtube.com/watch?v=iAP9AF6DCu4" ,
                            "https://www.youtube.com/watch?v=RvnkAtWcKYg" ,
                            "https://www.youtube.com/watch?v=1mjlM_RnsVE" ,
                            "https://www.youtube.com/watch?v=vc6vs-l5dkc" ,
                            "https://www.youtube.com/watch?v=7QU1nvuxaMA" ,
                            "https://www.youtube.com/watch?v=xPU8OAjjS4k" ,
                            "https://www.youtube.com/watch?v=gnhXHvRoUd0" ,
                            "https://www.youtube.com/watch?v=Gd9OhYroLN0" ,
                            "https://www.youtube.com/watch?v=-tJYN-eG1zk" ,
                            "https://www.youtube.com/watch?v=Soa3gO7tL-c" ,
                            "https://www.youtube.com/watch?v=o_l4Ab5FRwM" ,
                            "https://www.youtube.com/watch?v=XEEasR7hVhA" ,
                            "https://www.youtube.com/watch?v=lL2ZwXj1tXM" ,
                            "https://www.youtube.com/watch?v=6fVE8kSM43I" ,
                            "https://www.youtube.com/watch?v=cjVQ36NhbMk" ,
                            "https://www.youtube.com/watch?v=hPC2Fp7IT7o" ,
                            "https://www.youtube.com/watch?v=RiSfTyrvJlg" ,
                            "https://www.youtube.com/watch?v=94bGzWyHbu0" ,
                            "https://www.youtube.com/watch?v=BfOdWSiyWoc" ,
                            "https://www.youtube.com/watch?v=NUTGr5t3MoY" ,
                            "https://www.youtube.com/watch?v=CDl9ZMfj6aE" ,
                            "https://www.youtube.com/watch?v=Y5fBdpreJiU" ,
                            "https://www.youtube.com/watch?v=Wws7mnMewPw" ,
                            "https://www.youtube.com/watch?v=xqds0B_meys" ,
                            "https://www.youtube.com/watch?v=7Xf-Lesrkuc" ,
                            "https://www.youtube.com/watch?v=ac3HkriqdGQ" ,
                            "https://www.youtube.com/watch?v=f0EQlIzPowM" ,
                            "https://www.youtube.com/watch?v=DWaB4PXCwFU" ,
                            "https://www.youtube.com/watch?v=LoheCz4t2xc" ,
                            "https://www.youtube.com/watch?v=Ud4HuAzHEUc" ,
                            "https://www.youtube.com/watch?v=8yvGCAvOAfM" ,
                            "https://www.youtube.com/watch?v=onzL0EM1pKY" ,
                            "https://www.youtube.com/watch?v=DmeUuoxyt_E" ,
                            "https://www.youtube.com/watch?v=9sTQ0QdkN3Q" ,
                            "https://www.youtube.com/watch?v=co4YpHTqmfQ" ,
                            "https://www.youtube.com/watch?v=_JQiEs32SqQ" ,
                            "https://www.youtube.com/watch?v=ff0oWESdmH0" ,
                            "https://www.youtube.com/watch?v=OYjZK_6i37M" ,
                            "https://www.youtube.com/watch?v=DelhLppPSxY" ,
                            "https://www.youtube.com/watch?v=3mbBbFH9fAg" ,
                            "https://www.youtube.com/watch?v=jRGrNDV2mKc" ,
                            "https://www.youtube.com/watch?v=HIRNdveLnJI" ,
                            "https://www.youtube.com/watch?v=e8X3ACToii0" ,
                            "https://www.youtube.com/watch?v=uxUATkpMQ8A" ,
                            "https://www.youtube.com/watch?v=VurhzANQ_B0" ,
                            "https://www.youtube.com/watch?v=PJGpsL_XYQI" ,
                            "https://www.youtube.com/watch?v=jhC1pI76Rqo" ,
                            "https://www.youtube.com/watch?v=_RrA-R5VHQs" ,
                            "https://www.youtube.com/watch?v=CSJXle3LP_Q" ,
                            "https://www.youtube.com/watch?v=2aJUnltwsqs" ,
                            "https://www.youtube.com/watch?v=Ow_qI_F2ZJI" ,
                            "https://www.youtube.com/watch?v=6Whgn_iE5uc" ,
                            "https://www.youtube.com/watch?v=kDWgsQhbaqU" ,
                            "https://www.youtube.com/watch?v=Vrr3lRLjZ1Y" ,
                            "https://www.youtube.com/watch?v=7G8QItjTSDA" ,
                            "https://www.youtube.com/watch?v=gPDcwjJ8pLg" ,
                            "https://www.youtube.com/watch?v=qxDcWvZCSRg" ,
                            "https://www.youtube.com/watch?v=s88r_q7oufE" ,
                            "https://www.youtube.com/watch?v=xJJsoquu70o" ,
                            "https://www.youtube.com/watch?v=araU0fZj6oQ" ,
                            "https://www.youtube.com/watch?v=9-SQGOYOjxs" ,
                            "https://www.youtube.com/watch?v=uhG-vLZrb-g" ,
                            "https://www.youtube.com/watch?v=04F4xlWSFh0" ,
                            "https://www.youtube.com/watch?v=pFq1eT9tMJ4" ,
                            "https://www.youtube.com/watch?v=qpfhcljJ9bQ" ,
                            "https://www.youtube.com/watch?v=9gsAz6S_zSw" ,
                            "https://www.youtube.com/watch?v=_4VCpTZye10" ,
                            "https://www.youtube.com/watch?v=u_VsvZmIWxY" ,
                            "https://www.youtube.com/watch?v=GIzDsGyxsQM" ,
                            "https://www.youtube.com/watch?v=3moLkjvhEu0" ,
                            "https://www.youtube.com/watch?v=mhJh5_6MuCk" ,
                            "https://www.youtube.com/watch?v=09LTT0xwdfw" ,
                            "https://www.youtube.com/watch?v=YpJAmlnBxoA" ,
                            "https://www.youtube.com/watch?v=fQ9nQNx0KEs" ,
                            "https://www.youtube.com/watch?v=XBYhQnjyrWo" ,
                            "https://www.youtube.com/watch?v=8nW-IPrzM1g" ,
                            "https://www.youtube.com/watch?v=l9VFg44H2z8" ,
                            "https://www.youtube.com/watch?v=UQ92eyxnxmQ" ,
                            "https://www.youtube.com/watch?v=aWxBrI0g1kE" ,
                            "https://www.youtube.com/watch?v=IHgFJEJgUrg" ,
                            "https://www.youtube.com/watch?v=04fQTmvFfGo" ,
                            "https://www.youtube.com/watch?v=_DboMAghWcA" ,
                            "https://www.youtube.com/watch?v=rHBxJCq99jA" ,
                            "https://www.youtube.com/watch?v=rTiGlNDnOtE" ,
                            "https://www.youtube.com/watch?v=Aihu16RyYp8" ,
                            "https://www.youtube.com/watch?v=9SSUQxGjZZ4" ,
                            "https://www.youtube.com/watch?v=6Ux6SlOE9Qk" ,
                            "https://www.youtube.com/watch?v=zuQGx1H1Qh8" ,
                            "https://www.youtube.com/watch?v=dDxgSvJINlU" ,
                            "https://www.youtube.com/watch?v=pdEvL6jxUYA" ,
                            "https://www.youtube.com/watch?v=FZLILV18ut8" ,
                            "https://www.youtube.com/watch?v=7NQ8OCcQ3LA" ,
                            "https://www.youtube.com/watch?v=v2cRj9Z96PQ" ,
                            "https://www.youtube.com/watch?v=bmtbg5b7_Aw" ,
                            "https://www.youtube.com/watch?v=LyA1GL1touw" ,
                            "https://www.youtube.com/watch?v=yfdAGkjHGac" ,
                            "https://www.youtube.com/watch?v=0Gjx-ZQuQ_Y" ,
                            "https://www.youtube.com/watch?v=XjQvk_R20r4" ,
                            "https://www.youtube.com/watch?v=Pn-6eOxnEMI" ,
                            "https://www.youtube.com/watch?v=WGt-8adyabk" ,
                            "https://www.youtube.com/watch?v=wsumEnI5O2k" ,
                            "https://www.youtube.com/watch?v=xmOOGeZE-aE" ,
                            "https://www.youtube.com/watch?v=-rdmG0k8S8k" ,
                            "https://www.youtube.com/watch?v=BHRyMcH6WMM" ,
                            "https://www.youtube.com/watch?v=GurkREc-q4I" ,
                            "https://www.youtube.com/watch?v=OjyZKfdwlng" ,
                            "https://www.youtube.com/watch?v=T3rXdeOvhNE" ,
                            "https://www.youtube.com/watch?v=LAMiX5EEbFU" ,
                            "https://www.youtube.com/watch?v=8Zx6RXGNISk" ,
                            "https://www.youtube.com/watch?v=ca9ub9rpNK4" ,
                            "https://www.youtube.com/watch?v=5ZF5m-vmDzM" ,
                            "https://www.youtube.com/watch?v=ptzzU7jFQwo" ,
                            "https://www.youtube.com/watch?v=opU1urLhw50" ,
                            "https://www.youtube.com/watch?v=tR-qQcNT_fY" ,
                            "https://www.youtube.com/watch?v=9itwt_opsvQ" ,
                            "https://www.youtube.com/watch?v=i9lYwVm1NDg" ,
                            "https://www.youtube.com/watch?v=XP4clbHc4Xg" ,
                            "https://www.youtube.com/watch?v=liW-kWFiXtQ" ,
                            "https://www.youtube.com/watch?v=trinU3VD1Zo" ,
                            "https://www.youtube.com/watch?v=ec0XKhAHR5I" ,
                            "https://www.youtube.com/watch?v=BvsMPOfblfg" ,
                            "https://www.youtube.com/watch?v=qQ3qJmgktS0" ,
                            "https://www.youtube.com/watch?v=vEN3mQ0ql30" ,
                            "https://www.youtube.com/watch?v=Dj_d8DlZ-Jo" ,
                            "https://www.youtube.com/watch?v=7bnX-6sJZBw" ,
                            "https://www.youtube.com/watch?v=dXMfdpjnAHU" ,
                            "https://www.youtube.com/watch?v=X9fLbfzCqWw" ,
                            "https://www.youtube.com/watch?v=wBgp5aDH23g" ,
                            "https://www.youtube.com/watch?v=9GFI6Rf-IkI" ,
                            "https://www.youtube.com/watch?v=OoHGZFyMCHU" ,
                            "https://www.youtube.com/watch?v=xY0HCKOmrW0" ,
                            "https://www.youtube.com/watch?v=REuLlW2ktMg" ,
                            "https://www.youtube.com/watch?v=EDKwCvD56kw" ,
                            "https://www.youtube.com/watch?v=V5UOC0C0x8Q" ,
                            "https://www.youtube.com/watch?v=tIgtaM7OV4g" ,
                            "https://www.youtube.com/watch?v=BJk6gZuPKRE" ,
                            "https://www.youtube.com/watch?v=HTvu1Yr3Ohk" ,
                            "https://www.youtube.com/watch?v=PMLsF8ajI6U" ,
                            "https://www.youtube.com/watch?v=rguhxKEBlr4" ,
                            "https://www.youtube.com/watch?v=_bISJ2zi1zQ" ,
                            "https://www.youtube.com/watch?v=LQUXuQ6Zd9w" ,
                            "https://www.youtube.com/watch?v=H25ORRgLxdA" ,
                            "https://www.youtube.com/watch?v=6nQCxwneUwA" ,
                            "https://www.youtube.com/watch?v=xTgKRCXybSM" ,
                            "https://www.youtube.com/watch?v=9zFfRSeA1ls" ,
                            "https://www.youtube.com/watch?v=A69BertdSt4" ,
                            "https://www.youtube.com/watch?v=dwxUgefMStM" ,
                            "https://www.youtube.com/watch?v=03X0B6u-AxM" ,
                            "https://www.youtube.com/watch?v=7LuSP4QaXiQ" ,
                            "https://www.youtube.com/watch?v=Y7NVxAMQn_I" ,
                            "https://www.youtube.com/watch?v=rSmtHBMjXLU" ,
                            "https://www.youtube.com/watch?v=gy8HPSIFXEM" ,
                            "https://www.youtube.com/watch?v=HdnTSXUWd3E" ,
                            "https://www.youtube.com/watch?v=4zRSSfw97XY" ,
                            "https://www.youtube.com/watch?v=eEn-nTkbEM0" ,
                            "https://www.youtube.com/watch?v=xXDC89tZ4IQ" ,
                            "https://www.youtube.com/watch?v=50WH8OpSTS4" ,
                            "https://www.youtube.com/watch?v=202fjZZO-tI" ,
                            "https://www.youtube.com/watch?v=1ybaiCgOFUQ" ,
                            "https://www.youtube.com/watch?v=njJ7NZMH70M" ,
                            "https://www.youtube.com/watch?v=O4P7NxpsA2Q" ,
                            "https://www.youtube.com/watch?v=-U98qkjbYek" ,
                            "https://www.youtube.com/watch?v=nq9j1qkj2Vc" ,
                            "https://www.youtube.com/watch?v=gpyRI1j9t6c" ,
                            "https://www.youtube.com/watch?v=MLeIyy2ipps" ,
                            "https://www.youtube.com/watch?v=CVQC3bx_AXs" ,
                            "https://www.youtube.com/watch?v=t4kkzsRJObE" ,
                            "https://www.youtube.com/watch?v=WcwweoJDkV0" ,
                            "https://www.youtube.com/watch?v=T8dyxGiBx3g" ,
                            "https://www.youtube.com/watch?v=7zEm-U1hC7E" ,
                            "https://www.youtube.com/watch?v=Yo5fE-Zl-V4" ,
                            "https://www.youtube.com/watch?v=PTFwQP86BRs" ,
                            "https://www.youtube.com/watch?v=zIWeIChes5k" ,
                            "https://www.youtube.com/watch?v=RXks5M56aTI" ,
                            "https://www.youtube.com/watch?v=a1BS7XnEZqc" ,
                            "https://www.youtube.com/watch?v=pm-xlwkQ_qc" ,
                            "https://www.youtube.com/watch?v=1B89Osfj8dg" ,
                            "https://www.youtube.com/watch?v=VYIxUM-CnSw" ,
                            "https://www.youtube.com/watch?v=4NMxwbn_QoU" ,
                            "https://www.youtube.com/watch?v=BDKM181eTsM" ,
                            "https://www.youtube.com/watch?v=4sXoA7B5yJo" ,
                            "https://www.youtube.com/watch?v=zTuD8k3JvxQ" ,
                            "https://www.youtube.com/watch?v=g9z4DWB7Iy8" ,
                            "https://www.youtube.com/watch?v=WPpDyIJdasg" ,
                            "https://www.youtube.com/watch?v=MjwFe6okyUw" ,
                            "https://www.youtube.com/watch?v=Kv0B-DLtMiM" ,
                            "https://www.youtube.com/watch?v=IYnuSsM7tRw" ,
                            "https://www.youtube.com/watch?v=ere2Mstl8ww" ,
                            "https://www.youtube.com/watch?v=qP6JDLQF23g" ,
                            "https://www.youtube.com/watch?v=nuLMDvoshrk" ,
                            "https://www.youtube.com/watch?v=e8A9J94UWI8" ,
                            "https://www.youtube.com/watch?v=3g8v45du-ZA" ,
                            "https://www.youtube.com/watch?v=_TWr2pj6kqM" ,
                            "https://www.youtube.com/watch?v=ePVErcAUzK8" ,
                            "https://www.youtube.com/watch?v=YGchlqCjj8A" ,
                            "https://www.youtube.com/watch?v=Z-ChyVXzbjA" ,
                            "https://www.youtube.com/watch?v=Z3_lIPESVTw" ,
                            "https://www.youtube.com/watch?v=kgS1zjvCPF4" ,
                            "https://www.youtube.com/watch?v=zzTZeeMCUBk" ,
                            "https://www.youtube.com/watch?v=AhiIZKaRixs" ,
                            "https://www.youtube.com/watch?v=zBXkWVZD4qE" ,
                            "https://www.youtube.com/watch?v=TxVACta6dbA" ,
                            "https://www.youtube.com/watch?v=T0_zzCLLRvE" ,
                            "https://www.youtube.com/watch?v=thfpVOAC-y0" ,
                            "https://www.youtube.com/watch?v=fGT1QRyVYvY" ,
                            "https://www.youtube.com/watch?v=OPXUeeFXc90" ,
                            "https://www.youtube.com/watch?v=mk0PdLZqZqU" ,
                            "https://www.youtube.com/watch?v=m4yawisNuf8" ,
                            "https://www.youtube.com/watch?v=QkSASi_eN_k" ,
                            "https://www.youtube.com/watch?v=gCSs5QggRUk" ,
                            "https://www.youtube.com/watch?v=tMlKmELIhgY" ,
                            "https://www.youtube.com/watch?v=IfqIjQbn5TM" ,
                            "https://www.youtube.com/watch?v=p47CgsSz4dE" ,
                            "https://www.youtube.com/watch?v=8hkmuTvkp_s" ,
                            "https://www.youtube.com/watch?v=TfmD_YpyeSs" ,
                            "https://www.youtube.com/watch?v=mF53On_P7qI" ,
                            "https://www.youtube.com/watch?v=2qN5ewi44N8" ,
                            "https://www.youtube.com/watch?v=j47OMBfl-3A" ,
                            "https://www.youtube.com/watch?v=ev-bR9ii7Gs" ,
                            "https://www.youtube.com/watch?v=qk3vjIDuy9w" ,
                            "https://www.youtube.com/watch?v=_20CTa043IA" ,
                            "https://www.youtube.com/watch?v=IPtUV01R1RE" ,
                            "https://www.youtube.com/watch?v=6rL4em-Xv5o" ,
                            "https://www.youtube.com/watch?v=q1KL5U-fyMc" ,
                            "https://www.youtube.com/watch?v=rkPCb-uEjaI" ,
                            "https://www.youtube.com/watch?v=FqQsZ8g8KHQ" ,
                            "https://www.youtube.com/watch?v=C6iQpkkWZm0" ,
                            "https://www.youtube.com/watch?v=Bl1AXYOseuY" ,
                            "https://www.youtube.com/watch?v=p-N_y1bZtRw" ,
                            "https://www.youtube.com/watch?v=dOO4VZeH4-g" ,
                            "https://www.youtube.com/watch?v=etp8L9pbqeM" ,
                            "https://www.youtube.com/watch?v=ljvZ928YGrQ" ,
                            "https://www.youtube.com/watch?v=RhOQb-hrgpk" ,
                            "https://www.youtube.com/watch?v=xzkiJJ_NkD0" ,
                            "https://www.youtube.com/watch?v=FNdC_3LR2AI" ,
                            "https://www.youtube.com/watch?v=_CRWKTguxNQ" ,
                            "https://www.youtube.com/watch?v=09y8THtoqJc" ,
                            "https://www.youtube.com/watch?v=K2NGe9mLAEc" ,
                            "https://www.youtube.com/watch?v=kwbIkzDVVFQ" ,
                            "https://www.youtube.com/watch?v=C9GTEsNf_GU" ,
                            "https://www.youtube.com/watch?v=3ZoKmdbERzA" ,
                            "https://www.youtube.com/watch?v=7q2bNqe0Xyk" ,
                            "https://www.youtube.com/watch?v=wPW7T_tu3PM" ,
                            "https://www.youtube.com/watch?v=BsIXGVOvah8" ,
                            "https://www.youtube.com/watch?v=fj-10lIrboM" ,
                            "https://www.youtube.com/watch?v=Rl6h7WuXYIM" ,
                            "https://www.youtube.com/watch?v=CFOtX3VkG88" ,
                            "https://www.youtube.com/watch?v=MUXhUt7GjF8" ,
                            "https://www.youtube.com/watch?v=awyBrr0P69A" ,
                            "https://www.youtube.com/watch?v=DcfmwfY2GOE" ,
                            "https://www.youtube.com/watch?v=IXxHwOkYEYs" ,
                            "https://www.youtube.com/watch?v=M4sQfHD_b_E" ,
                            "https://www.youtube.com/watch?v=P027oGJy2n4" ,
                            "https://www.youtube.com/watch?v=F68owXsix9A" ,
                            "https://www.youtube.com/watch?v=UaVcRnPt3EM" ,
                            "https://www.youtube.com/watch?v=4MRLd1Cgbdg" ,
                            "https://www.youtube.com/watch?v=Hp6Qh-wT3ys" ,
                            "https://www.youtube.com/watch?v=5nSmdllDCtU" ,
                            "https://www.youtube.com/watch?v=l35hgJhs80M" ,
                            "https://www.youtube.com/watch?v=JzAv7K8BtN0" ,
                            "https://www.youtube.com/watch?v=M1cj2M_Mprw" ,
                            "https://www.youtube.com/watch?v=QiKK7ULsqXk" ,
                            "https://www.youtube.com/watch?v=hpbZMZm0kbE" ,
                            "https://www.youtube.com/watch?v=BBA4frqKvt8" ,
                            "https://www.youtube.com/watch?v=3VCvSJo-yC0" ,
                            "https://www.youtube.com/watch?v=70FI3c2ARKM" ,
                            "https://www.youtube.com/watch?v=XSNeeVLEnd8" ,
                            "https://www.youtube.com/watch?v=zO1_cpIIzXI" ,
                            "https://www.youtube.com/watch?v=ZQ8itDYP6HU" ,
                            "https://www.youtube.com/watch?v=-Aj9_8t1eQc" ,
                            "https://www.youtube.com/watch?v=0Dge-GrQ_NE" ,
                            "https://www.youtube.com/watch?v=cB4T7zTEDso" ,
                            "https://www.youtube.com/watch?v=VoA9tLkrgHY" ,
                            "https://www.youtube.com/watch?v=ZxRG7uoFDo4" ,
                            "https://www.youtube.com/watch?v=F3wMPkrz3Jw" ,
                            "https://www.youtube.com/watch?v=SqioRSYOWiY" ,
                            "https://www.youtube.com/watch?v=DKZ2PLTPYP8" ,
                            "https://www.youtube.com/watch?v=rInmvUKYeKA" ,
                            "https://www.youtube.com/watch?v=wJuEjAo4ues" ,
                            "https://www.youtube.com/watch?v=zj2uZO7xnus" ,
                            "https://www.youtube.com/watch?v=MwiYfNyC81A" ,
                            "https://www.youtube.com/watch?v=78pH07RFqmY" ,
                            "https://www.youtube.com/watch?v=rZwSqX6J5hs" ,
                            "https://www.youtube.com/watch?v=1m54kEblqhU" ,
                            "https://www.youtube.com/watch?v=acZbW-CmUTA" ,
                            "https://www.youtube.com/watch?v=cYw9ChYKcE4" ,
                            "https://www.youtube.com/watch?v=7TkokQjF71Q" ,
                            "https://www.youtube.com/watch?v=TbUAtnWwADI" ,
                            "https://www.youtube.com/watch?v=smvwKuqt_qU" ,
                            "https://www.youtube.com/watch?v=-nr31sZQJBg" ,
                            "https://www.youtube.com/watch?v=6_qbEsfJ4_8" ,
                            "https://www.youtube.com/watch?v=Dj1sVQ2qdnI" ,
                            "https://www.youtube.com/watch?v=MKCrxxflMkM" ,
                            "https://www.youtube.com/watch?v=p4h1wciz45o" ,
                            "https://www.youtube.com/watch?v=87ZV6VH46c8" ,
                            "https://www.youtube.com/watch?v=pnlwqqy4XB4" ,
                            "https://www.youtube.com/watch?v=Z2Wwt6a5zjw" ,
                            "https://www.youtube.com/watch?v=NU41o6Z-UlY" ,
                            "https://www.youtube.com/watch?v=dSoYMTOB9sg" ,
                            "https://www.youtube.com/watch?v=dddkcRIippE" ,
                            "https://www.youtube.com/watch?v=F_GAxR9J06I" ,
                            "https://www.youtube.com/watch?v=-cxsTDnRN7M" ,
                            "https://www.youtube.com/watch?v=M3B5U1S-I4Y" ,
                            "https://www.youtube.com/watch?v=T2nfwK4f4LE" ,
                            "https://www.youtube.com/watch?v=0VNthEJlSdw" ,
                            "https://www.youtube.com/watch?v=WTPJSMvFBig" ,
                            "https://www.youtube.com/watch?v=bwBDnYj7plQ" ,
                            "https://www.youtube.com/watch?v=4ZsD5qz_T40" ,
                            "https://www.youtube.com/watch?v=R68rSUlrScU" ,
                            "https://www.youtube.com/watch?v=lFOYtq_HhQI" ,
                            "https://www.youtube.com/watch?v=HQ0DSJSZ1zo" ,
                            "https://www.youtube.com/watch?v=L1VIh_lEP_o" ,
                            "https://www.youtube.com/watch?v=PKzrzJxc8Jo" ,
                            "https://www.youtube.com/watch?v=JemASFItTiE" ,
                            "https://www.youtube.com/watch?v=7UtL6GDJwXQ" ,
                            "https://www.youtube.com/watch?v=kUHsY6gPCys" ,
                            "https://www.youtube.com/watch?v=Jb6dyGsJfMM" ,
                            "https://www.youtube.com/watch?v=eGR1ljWZwVE" ,
                            "https://www.youtube.com/watch?v=kxlbcQ9_GVU" ,
                            "https://www.youtube.com/watch?v=Xr2phSxlCb4" ,
                            "https://www.youtube.com/watch?v=9b1R3jqUCP4" ,
                            "https://www.youtube.com/watch?v=CYIEGaIjklk" ,
                            "https://www.youtube.com/watch?v=CPr1JR1Iu3w" ,
                            "https://www.youtube.com/watch?v=6cEZAaTK9TU" ,
                            "https://www.youtube.com/watch?v=_FVCjPbKr2w" ,
                            "https://www.youtube.com/watch?v=xptsm1grGvQ" ,
                            "https://www.youtube.com/watch?v=WujP0VgeJC8" ,
                            "https://www.youtube.com/watch?v=67Vyl71gcpU" ,
                            "https://www.youtube.com/watch?v=7LEjSYU-_T8" ,
                            "https://www.youtube.com/watch?v=QIEQmGcibhc" ,
                            "https://www.youtube.com/watch?v=D8xpx5RMoZc" ,
                            "https://www.youtube.com/watch?v=bva0Ct2hG7Y" ,
                            "https://www.youtube.com/watch?v=qtJ1K2Wm9JM" ,
                            "https://www.youtube.com/watch?v=9PA3rwOBC8E" ,
                            "https://www.youtube.com/watch?v=f8yiyvqzkQ8" ,
                            "https://www.youtube.com/watch?v=T5dQMunUbv0" ,
                            "https://www.youtube.com/watch?v=e2W_HcXhWEM" ,
                            "https://www.youtube.com/watch?v=uzzlYnEvKog" ,
                            "https://www.youtube.com/watch?v=FYmiOhSBB28" ,
                            "https://www.youtube.com/watch?v=O5ecIvC16zA" ,
                            "https://www.youtube.com/watch?v=bzDTzwKoVNw" ,
                            "https://www.youtube.com/watch?v=_GipmdQMeFQ" ,
                            "https://www.youtube.com/watch?v=F9R-rgLaTVA" ,
                            "https://www.youtube.com/watch?v=mmoXbJSgK2o" ,
                            "https://www.youtube.com/watch?v=l_t3vge2QYU" ,
                            "https://www.youtube.com/watch?v=c823kZQMkUU" ,
                            "https://www.youtube.com/watch?v=pDLmXu9JBa0" ,
                            "https://www.youtube.com/watch?v=gJCNerq7x6o" ,
                            "https://www.youtube.com/watch?v=2sWwKynqNwY" ,
                            "https://www.youtube.com/watch?v=JTlLZTeck4s" ,
                            "https://www.youtube.com/watch?v=x94BFdjBl9w"
                    };
    int urlNum;

    CustomTabsClient mCustomTabsClient;
    CustomTabsSession mCustomTabsSession;
    CustomTabsServiceConnection mCustomTabsServiceConnection;
    CustomTabsIntent mCustomTabsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCustomTabsServiceConnection = new CustomTabsServiceConnection() {
            @Override
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                mCustomTabsClient = customTabsClient;
                mCustomTabsClient.warmup(0L);
                mCustomTabsSession = mCustomTabsClient.newSession(null);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mCustomTabsClient = null;
            }
        };

        CustomTabsClient.bindCustomTabsService(this, CUSTOM_TAB_PACKAGE_NAME, mCustomTabsServiceConnection);

        mCustomTabsIntent = new CustomTabsIntent.Builder(mCustomTabsSession)
                .setShowTitle(true)
                .build();
    }

    public void chromeCustomTab(View view) {
        Random rand = new Random();
        urlNum = rand.nextInt(urls.length);

        mCustomTabsIntent.launchUrl(this, Uri.parse(urls[urlNum]));
        Context context = getApplicationContext();
        CharSequence text = toastMessages[rand.nextInt(toastMessages.length)];
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void chromeCustomTabVid(View view) {
        Random rand = new Random();
        urlNum = rand.nextInt(videos.length);

        mCustomTabsIntent.launchUrl(this, Uri.parse(videos[urlNum]));
        Context context = getApplicationContext();
        CharSequence text = "Make sure you're wearing earphones!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void about(MenuItem item) {
       Intent myIntent = new Intent(MainActivity.this, AboutActivity.class);
       MainActivity.this.startActivity(myIntent);
    }
}
