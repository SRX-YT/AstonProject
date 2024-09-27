package service.comparator;

import model.RootCrop;

import java.util.Comparator;

public class RootCropWeightComparator implements Comparator<RootCrop> {
    @Override
    public int compare(RootCrop rootCrop1, RootCrop rootCrop2) {
        return Double.compare(rootCrop1.getWeight(), rootCrop2.getWeight());
    }
}
