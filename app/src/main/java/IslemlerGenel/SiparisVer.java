package IslemlerGenel;

import android.support.constraint.ConstraintLayout;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

import FirebaseIslem.FirebaseProcess;
import FirebaseIslem.firebaseVeriEkleme.SiparisAdd;
import IslemlerGenel.HideShowElement.HideShow;
import Kullanici.Musteri;

public class SiparisVer {

    public void SiparisHazirla(EditText editText, TextView textView, ConstraintLayout constraintLayout) {

        String adet = editText.getText().toString();
        String siparis[] = regexFiyat(textView.getText().toString());

        if (Integer.parseInt(adet) >= 1 && siparis.length >= 2) {
            HasmapHazirla hasmapHazirla = new HasmapHazirla();

            HashMap siparisHasmap = hasmapHazirla.SiparisHasmap(siparis, adet);

            textBosalt(editText, textView);

            this.siparisiVer(siparisHasmap);
            this.gizleLayout(constraintLayout);

        }
        else {
            CreateToast.makeToast("Lütfen tüm seçimlerinizi yapınız");
        }
    }

    private void textBosalt(EditText editText, TextView textView)
    {
        textView.setText("");
        editText.setText("");
    }
    private String [] regexFiyat(String fiyat)
    {
        return  fiyat.split("Fiyat= ");
    }

    private void gizleLayout(ConstraintLayout constraintLayout)
    {
        HideShow hideShow = new HideShow();
        hideShow.hide(constraintLayout);
    }

    private void siparisiVer(HashMap siparisHasmap)
    {
        FirebaseProcess firebaseProcess = new FirebaseProcess();
        firebaseProcess.firebaseAdd(new SiparisAdd(), siparisHasmap);
        musteriSiparisEkle(siparisHasmap);
    }
    private void musteriSiparisEkle(HashMap hashMap)
    {
        Musteri.getObjeck().siparis(hashMap.get("siparis").toString(), hashMap.get("adet").toString(), hashMap.get("fiyat").toString());
    }
}
