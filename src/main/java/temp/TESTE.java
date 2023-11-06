package temp;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.util.ArrayList;
import java.util.List;

public class TESTE {

    public static void main(String[] args) {

        System.out.println("0123456789".substring(0, 1));

        //System.out.println(String.format("%02d", 1));

     }


    /*private boolean validatePolicySituationReason(FieldObject<ClaimAvailabilityInput> legacyInput,
                                                  FieldObject<ClaimAvailabilityResponse> legacyOutput) {

        String config = "";
        boolean resultCheck = false;

        for (int i = 0; i < config.length(); i += 2) {
            if (checkPolicySituationReasonByConfigPosition(legacyInput, config, resultCheck, i, i + 2,
                    legacyOutput)) {
                return true;
            }
        }
        return resultCheck;

    }

    private boolean checkPolicySituationReasonByConfigPosition(
            FieldObject<ClaimAvailabilityInput> legacyInput, String config, boolean resultCheck,
            int initialPosition, int finalPosition, FieldObject<ClaimAvailabilityResponse> legacyOutput) {
        if (config.substring(initialPosition, finalPosition).contains("*")) {
            if (legacyInput.get().getPolicyHeader().getPolicySituation() == Integer
                    .parseInt(config.substring(initialPosition, finalPosition - 1))) {
                resultCheck = true;
                errorsClaim
                        .add(new ClaimException(new I2SMessage(I2SMessageType.ERROR, LFELFE.LFELFE0000238,
                                String.valueOf(legacyInput.get().getPolicyHeader().getPolicySituation()),
                                legacyInput.get().getPolicyHeader().getPolicyReason(),
                                String.valueOf(legacyInput.get().getPolicyHeader().getPolicyCode()))));
                legacyOutput.get().setErrorsClaim(errorsClaim);
            }
        } else {
            if (legacyInput.get().getPolicyHeader().getPolicySituation() == Integer
                    .parseInt(config.substring(initialPosition, finalPosition - 1))
                    && legacyInput.get().getPolicyHeader().getPolicyReason()
                    .equals(config.substring(finalPosition - 1, finalPosition))) {
                resultCheck = true;
                errorsClaim
                        .add(new ClaimException(new I2SMessage(I2SMessageType.ERROR, LFELFE.LFELFE0000238,
                                String.valueOf(legacyInput.get().getPolicyHeader().getPolicySituation()),
                                legacyInput.get().getPolicyHeader().getPolicyReason(),
                                String.valueOf(legacyInput.get().getPolicyHeader().getPolicyCode()))));
                legacyOutput.get().setErrorsClaim(errorsClaim);
            }
        }
        return resultCheck;
    }*/
}
