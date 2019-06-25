package com.clinic.cardio.models;

public class EchoTestEnums {

    enum AI {
        MILD("Mild", "Mild aortic regurgitation."),
        MILD_MODERATE("Mild-Moderate", "Mild to moderate aortic regurgitation."),
        MODERATE("Moderate", "Moderate aortic regurgitation."),
        MODERATE_SEVERE("Moderate-Severe", "Moderate to severe aortic regurgitation."),
        NONE("None", "No aortic regurgitation."),
        SEVERE("Severe", "Severe aortic regurgitation."),
        SEVERE_REVERSAL("Severe-Reversal", "Severe aortic regurgitation with flow reversal in descending aorta."),
        TRACE("Trace", "Trace aortic regurgitation."),
        TRACE_MILD("Trace-Mild", "Trace to mild aortic regurgitation.");

        private final String displayName;
        private final String description;
        
        AI(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }

    enum AORTA {
        AAC("AAC", "Aortic annulus calcification present."),
        ASC_DILATED("Asc. Dilated", "Dilated Ascending Aorta."),
        ATHEROMA("Atheroma", "Aortic atheroma present."),
        COARCTION("Coarctation", "Coarctation of Aorta present."),
        COR_SINUS("Cor. Sinus Dilated", "Dilated Aorta at coronary sinus level."),
        DILATED_ROOT("Dilated-root", "Dilated Aortic root."),
        NO_COARCTATION("No Coarctation", "No coarctation of Aorta."),
        NORMAL("Normal", "Aorta appears normal.");

        private final String displayName;
        private final String description;

        AORTA(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum ASAV {
        CRITICAL("Critical", "Critical aortic stenosis."),
        MILD("Mild", "Mild aortic stenosis."),
        MILD_MODERATE("Mild-Moderate", "Mild to moderate aortic stenosis."),
        MODERATE("Moderate", "Moderate aortic stenosis."),
        MODERATE_SEVERE("Moderate-Severe", "Moderate to severe aortic stenosis."),
        NONE("None", "No aortic stenosis."),
        SEVERE("Severe", "Severe aortic stenosis.");

        private final String displayName;
        private final String description;

        ASAV(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }



    enum AV {
        BICUSPID_10_4("Bicuspid 10-4", "Aortic valve was bicuspid (10 – 4 o’clock configurations)."),
        BICUSPID_1_7("Bicuspid 1-7", "Aortic valve was bicuspid (1 – 7 o’clock configurations)."),
        BICUSPID_9_3("Bicuspid 9-3", "Aortic valve was bicuspid (9 – 3 o’clock configurations)."),
        BIO("Bio", "Aortic valve was bio-prosthetic."),
        MECHANICAL("Mechanical", "Aortic valve was mechanical."),
        MILD_THICK("Mild/Thick", "Aortic valve was trileaflet and mildly thickened."),
        NORMAL("Normal", "Aortic valve was trileaflet with normal function."),
        THICK("Thick", "Aortic valve was trileaflet and thickened.");

        private final String displayName;
        private final String description;

        AV(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum CLOT {
        NONE("None", "No left ventricular clot noted."),
        PROTRUDING("Protruding", "Protruding left ventricular clot detected."),
        SESSILE("Sessile", "Sessile left ventricular clot detected.");

        private final String displayName;
        private final String description;

        CLOT(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum DIASFUNC {
        ATRIAL_FIB("Atrial Fibrillation", "Unable to accurately assess diastolic function due to atrial fibrillation."),
        AGE("Age", "Diastolic dysfunction, may be an age related finding."),
        AI("AI", "Unable to accurately assess diastolic function due to aortic insufficiency."),
        HTN("HTN", "Diastolic dysfunction secondary to hypertension."),
        IMPAIRED_RELAX("Impaired Relax", "Mitral valve flow compatible with impaired relaxation."),
        MS("MS", "Unable to accurately assess diastolic function due to mitral stenosis."),
        NORMAL("Normal", "Normal diastolic function."),
        RESTRICTIVE("Restrictive", "Mitral valve flow compatible with restrictive filling."),
        TACHYCARDIA("Tachycardia", "Unable to accurately assess diastolic function due to tachycardia.");

        private final String displayName;
        private final String description;

        DIASFUNC(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum GRADES {
        ZERO_ONE("0-1", "Grade I left ventricular systolic function."),
        ONE("1", "Left ventricular systolic function was normal - grade 1."),
        ONE_TWO("1-2", "Grade I - II left ventricular systolic function."),
        TWO("2", "Grade II left ventricular systolic function."),
        TWO_THREE("2-3", "Grade II - III left ventricular systolic function."),
        THREE("3", "Grade III left ventricular systolic function."),
        THREE_FOUR("3-4", "Grade III - IV left ventricular systolic function."),
        FOUR("4", "Grade IV left ventricular systolic function."),
        HYPERDYNAMIC("Hyperdynamic", "Hyperdynamic left ventricle."),
        TDS("TDS", "Technically difficult study, images obtained are suboptimal.");

        private final String displayName;
        private final String description;

        GRADES(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum IMAGEQUALITY {
        ECELLENT("Excellent", "Excellent."),
        GOOD("Good", "Good."),
        LIMITED_APICAL("Limited Apical", "Limited Apical."),
        POOR("Poor", "Poor.");

        private final String displayName;
        private final String description;

        IMAGEQUALITY(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum LA {
        DILATED("Dilated", "Dilated left atrium."),
        MASSIVE("Massive", "Massive dilatation of left atrium."),
        NORMAL("Normal", "Normal left atrial size."),
        UPPER_LIMIT("Upper Limit ", "Left atrial size is at upper limits of normal.");

        private final String displayName;
        private final String description;

        LA(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum LVD {
        MILD_DILATED("Mild Dilated", "LV cavity size is mildly dilated."),
        MODERATELY_DILATED("Moderately Dilated", "LV cavity is moderately dilated."),
        NORMAL("Normal", "Normal LV cavity size."),
        SEVERE("Severe", "LV cavity is severely dilated.");

        private final String displayName;
        private final String description;

        LVD(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum LVH {
        ASYMETRIC("Asymmetric", "Asymmetric septal hypertrophy."),
        BASAL("Basal", "Basal septal hypertrophy."),
        BORDERLINE("Borderline", "Borderline left ventricular hypertrophy."),
        CONCENTRIC("Concentric", "Concentric left ventricular hypertrophy."),
        MILD("Mild", "Mild concentric left ventricular hypertrophy."),
        NONE("None", "No left ventricular hypertrophy."),
        SIGMOID("Sigmoid", "Sigmoid septum.");

        private final String displayName;
        private final String description;

        LVH(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }
    

    enum MR {
        MILD("Mild", "Mild mitral regurgitation."),
        MILD_MODERATE("Mild-Moderate", "Mild to moderate mitral regurgitation."),
        MODERATE("Moderate", "Moderate mitral regurgitation."),
        MODERATE_SEVERE("Moderate-Severe", "Moderate to severe mitral regurgitation."),
        NONE("None", "No mitral regurgitation."),
        SEVERE("Severe", "Severe mitral regurgitation."),
        SEVERE_BLUNTING("Severe-Blunting", "Severe mitral regurgitation" +
                " with systolic blunting of pulmonary venous inflow."),
        TRACE("Trace", "Trace mitral regurgitation."),
        TRACE_MILD("Trace-Mild", "Trace to mild mitral regurgitation.");

        private final String displayName;
        private final String description;

        MR(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum MS {
        MILD("Mild", "Mild mitral valve stenosis."),
        MILD_MODERATE("Mild-Moderate", "Mild to moderate mitral valve stenosis."),
        MODERATE("Moderate", "Moderate mitral valve stenosis."),
        MODERATE_SEVERE("Moderate-Severe", "Moderate to severe mitral valve stenosis."),
        NONE("None", "No mitral valve stenosis."),
        SEVERE("Severe", "Severe mitral valve stenosis.");

        private final String displayName;
        private final String description;

        MS(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum MV {
        BIO("Bio", "Bio-prosthetic mitral valve present."),
        LOW_OUTPUT("Low Output", "Mitral valve is of low output with restricted excursion and increased E-point septal separation."),
        MAC("MAC", "Mitral annulus calcification is present."),
        MAC_THICK("MAC/Thick", "Mitral valve leaflets were thickened with annular calcification."),
        MECHANICAL("Mechanical", "Mechanical prosthetic mitral valve present."),
        MILD_THICK("Mild/Thick", "Mitral valve leaflets are mildly thickened."),
        MYXOMATOUS("Myxomatous", "Mitral valve leaflets are thickened and myxomatous."),
        NORMAL("Normal", "Mitral valve leaflets are normal."),
        RHEUMATIC("Rheumatic", "Mitral valve leaflets are thickened and rheumatic."),
        THICK("Thick", "Mitral valve leaflets are thickened.");

        private final String displayName;
        private final String description;

        MV(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum MVP {
        ANTERIOR("Anterior", "Anterior mitral valve prolapse."),
        BILEAFLET("Bileaflet", "Bileaflet mitral valve prolapse."),
        BORDERLINE("Borderline", "Borderline mitral valve prolapse."),
        NONE("None", "No mitral valve prolapse."),
        POSTERIOR("Posterior", "Posterior mitral valve prolapse.");

        private final String displayName;
        private final String description;

        MVP(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum PE {
        MILD("Mild", "Small pericardial effusion present."),
        MODERATE("Moderate", "Medium pericardial effusion present."),
        NO_TAMP("No Tamp", "No echocardiographic findings of tamponade are present."),
        NONE("None", "No pericardial effusion present."),
        SEVERE("Severe", "Large pericardial effusion present."),
        TAMPONADE("Tamponade", "Echocardiographic findings of tamponade are present."),
        TRACE("Trace", "Tiny pericardial effusion present.");

        private final String displayName;
        private final String description;

        PE(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum PI {
        MILD("Mild", "Mild pulmonary insufficiency."),
        MODERATE("Moderate", "Moderate pulmonary insufficiency."),
        NONE("None", "No pulmonary insufficiency."),
        SEVERE("Severe", "Severe pulmonary insufficiency."),
        TRACE("Trace", "Trace pulmonary insufficiency.");

        private final String displayName;
        private final String description;

        PI(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum PROPHYLAXIS {
        NO("No", "Antibiotic prophylaxis is not indicated."),
        YES("Yes", "Antibiotic prophylaxis is recommended by echo findings.");

        private final String displayName;
        private final String description;

        PROPHYLAXIS(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum PS {
        CRITICAL("Critical", "Critical pulmonic stenosis."),
        MILD("Mild", "Mild pulmonic stenosis."),
        MILD_MODERATE("Mild-Moderate", "Mild to moderate pulmonic stenosis."),
        MODERATE("Moderate", "Moderate pulmonic stenosis."),
        MODERATE_SEVERE("Moderate-Severe", "Moderate to severe pulmonic stenosis."),
        NONE("None", "No pulmonic stenosis."),
        SEVERE("Severe", "Severe pulmonic stenosis.");

        private final String displayName;
        private final String description;

        PS(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum PULHYP {
        NONE("None", "No pulmonary hypertension."),
        MILD("Mild", "Mild pulmonary hypertension."),
        MODERATE("Moderate", "Moderate pulmonary hypertension."),
        SEVERE("Severe", "Severe pulmonary hypertension."),
        MILD_SEVERE("Mild-Moderate", "Mild to moderate pulmonary hypertension."),
        MODERATE_SEVERE("Moderate-Severe", "Moderate to severe pulmonary hypertension."),
        CRITICAL("Critical", "Critical pulmonary hypertension."),
        PAT("PAT", "PAT > 100 ms. consistent with normal pulmonary pressures."),
        BORDERLINE("Borderline", "Borderline Pulmonary systolic pressure."),
        BORDERLINE_SYSTOLIC("Borderline-Systolic", "Borderline pulmonary hypertension.");

        private final String displayName;
        private final String description;

        PULHYP(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum PV {
        NORMAL("Normal", "Pulmonary valve was normal."),
        THICK("Thick", "Pulmonary valve appears thickened."),
        MILD_THICK("Mild/Thick", "Pulmonary valve leaflets were mildly thickened but not restricted."),
        THICK_STENOSIS("Thick/Stenosis", "Pulmonary valve leaflets were thickened consistent with pulmonary stenosis.");

        private final String displayName;
        private final String description;

        PV(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum RA {
        DILATED("Dilated", "Dilated right atrium."),
        MASSIVE("Massive", "Massive dilatation of right atrium."),
        NORMAL("Normal", "Normal right atrial size."),
        UPPER_LIMIT("Upper Limit", "Right atrial size is at upper limits of normal.");

        private final String displayName;
        private final String description;

        RA(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum RV {
        DILATED("Dilated", "Right ventricle was dilated."),
        DILATED_HYPO("Dilated/Hypo", "Dilated and hypokinetic right ventricle."),
        DILATED_RVOT_PA("Dilated RVOT PA", "Dilated right ventricular outflow tract and main pulmonary artery."),
        HYPERTROPHY("Hypertrophy", "Right ventricular free wall is thickened, possibly right ventricular hypertrophy."),
        HYPO("Hypo", "Right ventricle at normal size and hypokinetic."),
        NORMAL("Normal", "Normal right ventricle in size and function."),
        PRESSURE_OVERLOAD("Pressure Overload", "The ventricular septum was flat in systole and diastole consistent with right ventricular pressure overload."),
        VOLUME_OVERLOAD("Volume Overload", "The ventricular septum was flat in diastole consistent with right ventricular volume overload.");

        private final String displayName;
        private final String description;

        RV(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum TR {
        MILD("Mild", "Mild tricuspid regurgitation."),
        MILD_MODERATE("Mild-Moderate", "Mild to moderate tricuspid regurgitation."),
        MODERATE_SEVERE("Moderate-Severe", "Moderate to severe tricuspid regurgitation."),
        MODERATE("Moderate", "Moderate tricuspid regurgitation."),
        NONE("None", "No tricuspid regurgitation."),
        SEVERE("Severe", "Severe tricuspid regurgitation."),
        SEVERE_BLUNTING("Severe-Blunting", "Severe tricuspid regurgitation with systolic blunting of Inferior Vena Cava flow."),
        TRACE("Trace", "Trace physiologic tricuspid regurgitation."),
        TRACE_MILD("Trace-Mild", "Trace to mild tricuspid regurgitation.");

        private final String displayName;
        private final String description;

        TR(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }


    enum TV {
        NORMAL("Normal", "Normal tricuspid valve."),
        THICK("Thick", "Tricuspid valve appears thickened."),
        TVP("TVP", "Tricuspid valve prolapse noted.");

        private final String displayName;
        private final String description;

        TV(String displayName, String description) {
            this.displayName = displayName;
            this.description = description;
        }
        public String getDisplayName() {
            return displayName;
        }
        public String getDescription() {
            return description;
        }
    }

}
