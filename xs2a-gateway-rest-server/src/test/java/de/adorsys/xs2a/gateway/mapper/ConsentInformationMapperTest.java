package de.adorsys.xs2a.gateway.mapper;

import de.adorsys.xs2a.gateway.model.ais.ConsentInformationResponse200Json;
import de.adorsys.xs2a.gateway.model.ais.ConsentStatusTO;
import de.adorsys.xs2a.gateway.service.Links;
import de.adorsys.xs2a.gateway.service.ais.AccountAccess;
import de.adorsys.xs2a.gateway.service.ais.ConsentInformation;
import de.adorsys.xs2a.gateway.service.ais.ConsentStatus;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsentInformationMapperTest {

    private static final LocalDate VALID_UNTIL = LocalDate.of(2121, 12, 12);
    private static final int FREQUENCY_PER_DAY = 10;
    private static final LocalDate LAST_ACTION_DATE = LocalDate.of(2021, 10, 10);

    private ConsentInformationMapper consentInformationMapper = Mappers.getMapper(ConsentInformationMapper.class);

    @Test
    public void toConsentInformationResponse200Json() {
        ConsentInformationResponse200Json consentInformationResponse200Json =
                consentInformationMapper.toConsentInformationResponse200Json(consentInformation());
        assertThat(consentInformationResponse200Json.getAccess()).isNotNull();
        assertThat(consentInformationResponse200Json.getRecurringIndicator()).isTrue();
        assertThat(consentInformationResponse200Json.getValidUntil()).isEqualTo(VALID_UNTIL);
        assertThat(consentInformationResponse200Json.getFrequencyPerDay()).isEqualTo(FREQUENCY_PER_DAY);
        assertThat(consentInformationResponse200Json.getLastActionDate()).isEqualTo(LAST_ACTION_DATE);
        assertThat(consentInformationResponse200Json.getConsentStatus()).isEqualTo(ConsentStatusTO.RECEIVED);
        assertThat(consentInformationResponse200Json.getLinks()).isNotNull();
    }

    private ConsentInformation consentInformation() {
        ConsentInformation consentInformation = new ConsentInformation();
        consentInformation.setAccess(new AccountAccess());
        consentInformation.setRecurringIndicator(true);
        consentInformation.setValidUntil(VALID_UNTIL);
        consentInformation.setFrequencyPerDay(FREQUENCY_PER_DAY);
        consentInformation.setLastActionDate(LAST_ACTION_DATE);
        consentInformation.setConsentStatus(ConsentStatus.RECEIVED);
        consentInformation.setLinks(new Links());
        return consentInformation;
    }
}