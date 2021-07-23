package com.ddcat.entity.dict;

import com.ddcat.entity.SysDictItem;
import lombok.Data;

import java.util.List;

/**
 * @author dd-cat
 */
@Data
public class DictItemUpdateDTO {

    List<SysDictItem> dictItemList;
}
