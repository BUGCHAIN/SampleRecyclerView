package app.bugchain.samplerecyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by POSEIDON on 22/4/2558.
 */
public class HeaderItem {

    private String title;
    private boolean isHeader;
    private String headerName;

    private void setHeaderName(String headerName){
        this.headerName = headerName;
    }
    public String getHeaderName(){
        return headerName;
    }
    private void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    private void setIsHeader(boolean isHeader){
        this.isHeader = isHeader;
    }
    public boolean getIsHeader(){
        return isHeader;
    }

    private HeaderItem setItems(String headerName,String title,boolean isHeader){

        HeaderItem items = new HeaderItem();
        items.setHeaderName(headerName);
        items.setTitle(title);
        items.setIsHeader(isHeader);
        return items;
    }

    public List<HeaderItem> getItems(){
        List<HeaderItem> list = new ArrayList<HeaderItem>();
        HeaderItem items = new HeaderItem();
        int item = 1;
        int header = 1;
        for(int i=1;i<33;i++){
            if(i==1 || i==18){
                list.add(items.setItems("Header " + header,String.valueOf(i),true));
                header++;
            }else{
                list.add(items.setItems("","Item " + item,false));
                item ++;
            }
        }
        return list;
    }

}
