package domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import domain.money.LottoMoney;

public class LottoFactory {

    private static final List<LottoNumber> LOTTO_NUMBERS = initLottoNumber();
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int FROM_INDEX = 0;
    private static final int LOTTO_SIZE = 6;

    private static List<LottoNumber> initLottoNumber() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = MINIMUM_LOTTO_NUMBER; i <= MAXIMUM_LOTTO_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        return lottoNumbers;
    }

    public static LottoTickets publishLottoTickets(LottoMoney lottoMoney) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        int lottoPurchaseCounts = lottoMoney.getLottoPurchaseCounts();
        for (int i = FROM_INDEX; i < lottoPurchaseCounts; i++) {
            lottoTickets.add(publishLottoTicket());
        }
        return new LottoTickets(lottoTickets);
    }

    private static LottoTicket publishLottoTicket() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<LottoNumber> slicedLottoNumbers = LOTTO_NUMBERS.subList(FROM_INDEX, LOTTO_SIZE);
        return new LottoTicket(new HashSet<>(slicedLottoNumbers));
    }
}
