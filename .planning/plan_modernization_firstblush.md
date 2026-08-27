## Plan: SCORM 4ED Modernization Roadmap

Modernize the legacy Java 6/IE8 applet-based test suite into a dual-mode system: (1) frozen legacy compatibility package for archival/repro and (2) modern browser + Java 21 LTS implementation. Start by baselining current behavior and dependencies, then incrementally replace applet/frame architecture with service-backed web flows, add unit/integration tests, and establish governance (security, accessibility, release, and conformance evidence).

**Steps**
1. Phase 0 - Program guardrails and success criteria
1. Define modernization acceptance criteria: SCORM conformance parity, browser matrix (evergreen current-2), accessibility target (WCAG 2.2 AA), and Java 21 baseline.
1. Capture dual-mode scope boundary: legacy package is read-only (security-isolated), modern package is actively maintained.
1. Establish risk register and migration governance cadence (weekly triage, conformance regression dashboard).

1. Phase 1 - Legacy baseline and reproducibility (*blocks all later phases*)
1. Reproduce current build and runtime behavior under legacy toolchain using existing Ant flow from [software_development/build.xml](software_development/build.xml) and prerequisites from [README.md](README.md).
1. Create a behavior baseline pack: golden logs, screenshots, and expected outcomes for representative LMS/SCO/CP/Manifest runs from [software_development/TestSuite](software_development/TestSuite).
1. Inventory applet and frameset touchpoints via [software_development/src/org/adl/logging/LogManagerInterfaceApplet.java](software_development/src/org/adl/logging/LogManagerInterfaceApplet.java), [software_development/TestSuite/LMSRTE/LMSControls.htm](software_development/TestSuite/LMSRTE/LMSControls.htm), [software_development/TestSuite/scoRTE/SCORTEMain.htm](software_development/TestSuite/scoRTE/SCORTEMain.htm), and [software_development/TestSuite/contentpackage/ContentPackageMain.htm](software_development/TestSuite/contentpackage/ContentPackageMain.htm).
1. Pin and document old-toolchain reproducibility image/VM (legacy JDK/JRE, browser, OS) for legal/audit traceability.

1. Phase 2 - Toolchain and dependency strategy (*depends on Phase 1*)
1. Determine oldest easily locatable no-change JDK/JRE by running a build/runtime matrix against archived distributions and recording pass/fail evidence. Candidate vendors/channels to evaluate first: Azul Zulu archives, BellSoft Liberica archives, Oracle archives.
1. Add deterministic Java compile settings to all Ant javac tasks (source/target/release-equivalent strategy for legacy lane), referencing files such as [software_development/buildAdlValidator.xml](software_development/buildAdlValidator.xml), [software_development/buildLMSTest.xml](software_development/buildLMSTest.xml), [software_development/buildSCOTest.xml](software_development/buildSCOTest.xml).
1. Produce dependency SBOM and vulnerability report for jars under [software_development/lib](software_development/lib), classify replace/upgrade/isolate decisions.
1. Keep Ant as primary orchestrator initially; design optional Maven/Gradle migration after functional parity.

1. Phase 3 - Test foundation (*depends on Phase 1, parallel with Phase 4 early design*)
1. Confirm no active unit-test framework usage despite bundled junit jar and create dedicated test source layout under software_development/test (aligned with build.properties testSource convention in [software_development/build.properties](software_development/build.properties)).
1. Add Ant test target and CI-friendly reports in a new unit-test build script; wire into top-level build as non-blocking first, then gating.
1. Implement first unit-test slice for deterministic core logic: [software_development/src/org/adl/datamodels/datatypes/DurationValidator.java](software_development/src/org/adl/datamodels/datatypes/DurationValidator.java), [software_development/src/org/adl/datamodels/datatypes/DateTimeValidator.java](software_development/src/org/adl/datamodels/datatypes/DateTimeValidator.java), and [software_development/src/org/adl/datamodels/DMTimeUtility.java](software_development/src/org/adl/datamodels/DMTimeUtility.java).
1. Expand coverage to parser/validator modules before touching high-risk runtime orchestration.

1. Phase 4 - Modern runtime architecture replacement (*depends on Phase 1; can run parallel with Phase 3 after baseline complete*)
1. Define replacement for applet capabilities (file save/load, environment checks, test control, log writing) currently centralized in applet-backed flows like [software_development/src/org/adl/logging/LogManagerInterfaceApplet.java](software_development/src/org/adl/logging/LogManagerInterfaceApplet.java).
1. Introduce Java 21 service layer/API facade to host functionality previously bridged through JSObject/applet integration.
1. Create compatibility adapters for log format and test-result semantics so modern and legacy outputs are comparable.
1. Establish data migration strategy for persisted artifacts (.obj, logs) in [software_development/TestSuite/LMSRTE](software_development/TestSuite/LMSRTE) and [software_development/TestSuite/saves](software_development/TestSuite/saves).

1. Phase 5 - Frontend modernization to HTML5/CSS3/ES6-ES2018 (*depends on Phase 4 API contracts*)
1. Replace framesets with semantic HTML5 layout regions for major entry flows using [software_development/TestSuite/LMSRTE/LMSRTEMain.htm](software_development/TestSuite/LMSRTE/LMSRTEMain.htm), [software_development/TestSuite/scoRTE/SCORTEMain.htm](software_development/TestSuite/scoRTE/SCORTEMain.htm), and [software_development/TestSuite/contentpackage/ContentPackageMain.htm](software_development/TestSuite/contentpackage/ContentPackageMain.htm) as migration anchors.
1. Move inline handlers/events to module-based JS and progressive enhancement; reduce JS footprint by prioritizing CSS layout/state patterns.
1. Remove legacy browser polyfills/sniffing from [software_development/TestSuite/scripts/BrowserDetect.js](software_development/TestSuite/scripts/BrowserDetect.js) and [software_development/TestSuite/scripts/EmulationCode.js](software_development/TestSuite/scripts/EmulationCode.js).
1. Apply responsive CSS refactor and shared design tokens across [software_development/TestSuite/css](software_development/TestSuite/css).

1. Phase 6 - Accessibility, security, and compliance hardening (*parallelizable with late Phase 5*)
1. Accessibility remediation pass against WCAG 2.2 AA: keyboard flow, visible focus, landmark semantics, forms, contrast, error messaging, and assistive-tech labels.
1. Security hardening: CSP, input validation, secure file handling, dependency upgrades, signature/certificate policy replacement for post-applet model.
1. License/provenance review for third-party libraries and generated test artifacts.
1. Add threat model and secure release checklist.

1. Phase 7 - Verification and release readiness (*depends on Phases 3-6*)
1. Build multi-layer verification: unit tests, API/service integration tests, end-to-end browser tests, and SCORM conformance parity diffs against legacy baseline.
1. Execute browser compatibility matrix and accessibility audits.
1. Produce release artifacts: modern install guide, legacy archival guide, JDK vendor/version bill of materials, migration notes, rollback plan.
1. Tag first modern GA release and schedule deprecation milestones for legacy lane.

**Relevant files**
- [README.md](README.md) - Legacy prerequisites and runtime assumptions (Java 6u10, IE8).
- [software_development/build.xml](software_development/build.xml) - Top-level Ant orchestration and clean behavior.
- [software_development/build.properties](software_development/build.properties) - Existing testSource/testDir properties and environment wiring.
- [software_development/buildCTS.xml](software_development/buildCTS.xml) - Jar signing/unjar process including java40 netscape classes.
- [software_development/buildAdlValidator.xml](software_development/buildAdlValidator.xml) - Example javac settings target for deterministic compilation policy.
- [software_development/buildLMSTest.xml](software_development/buildLMSTest.xml) - LMS module compile pipeline.
- [software_development/buildSCOTest.xml](software_development/buildSCOTest.xml) - SCO module compile pipeline.
- [software_development/src/org/adl/logging/LogManagerInterfaceApplet.java](software_development/src/org/adl/logging/LogManagerInterfaceApplet.java) - Applet and JSObject dependency anchor.
- [software_development/src/org/adl/datamodels/datatypes/DurationValidator.java](software_development/src/org/adl/datamodels/datatypes/DurationValidator.java) - First unit-test candidate.
- [software_development/src/org/adl/datamodels/datatypes/DateTimeValidator.java](software_development/src/org/adl/datamodels/datatypes/DateTimeValidator.java) - First unit-test candidate.
- [software_development/src/org/adl/datamodels/DMTimeUtility.java](software_development/src/org/adl/datamodels/DMTimeUtility.java) - First unit-test candidate.
- [software_development/TestSuite/LMSRTE/LMSControls.htm](software_development/TestSuite/LMSRTE/LMSControls.htm) - Applet-backed browser controls.
- [software_development/TestSuite/LMSRTE/LMSRTEMain.htm](software_development/TestSuite/LMSRTE/LMSRTEMain.htm) - Frameset shell to replace.
- [software_development/TestSuite/scoRTE/SCORTEMain.htm](software_development/TestSuite/scoRTE/SCORTEMain.htm) - Frameset shell to replace.
- [software_development/TestSuite/contentpackage/ContentPackageMain.htm](software_development/TestSuite/contentpackage/ContentPackageMain.htm) - Frameset shell to replace.
- [software_development/TestSuite/scripts/BrowserDetect.js](software_development/TestSuite/scripts/BrowserDetect.js) - Legacy browser sniffing.
- [software_development/TestSuite/scripts/EmulationCode.js](software_development/TestSuite/scripts/EmulationCode.js) - Legacy compatibility script.
- [software_development/lib](software_development/lib) - Third-party jars requiring SBOM/CVE review.

**Verification**
1. Legacy reproducibility verified from clean environment by running default Ant build and executing representative LMS/SCO/CP/Manifest flows.
1. Oldest locatable no-change JDK/JRE selected using a recorded matrix (vendor, exact version, OS, checksum, pass/fail notes).
1. New unit tests run in CI and locally with published reports; initial baseline: deterministic validator/time utility coverage.
1. Modern browser E2E suite validates critical workflows on evergreen current-2 matrix.
1. Accessibility audits: automated scans plus manual keyboard/screen-reader checks against WCAG 2.2 AA criteria.
1. Conformance parity report compares modern vs legacy logs/results for selected canonical test packages.

**Decisions**
- Confirmed: Dual mode strategy (legacy archival + modern active lane).
- Confirmed: Java target is OpenJDK 21 LTS for modern lane.
- Confirmed: Browser support is evergreen current-2.
- Confirmed: Keep Ant as primary build during initial migration.
- Included in scope: architecture replacement of applet/frameset runtime, testing foundation, accessibility/security/compliance hardening.
- Excluded from initial scope: immediate full build-system migration to Maven/Gradle, broad UI redesign beyond parity + accessibility.

**Further Considerations**
1. Compliance evidence management: decide whether to formalize a traceability matrix mapping each SCORM requirement to automated/manual tests and artifacts.
1. Deployment target: choose whether the modern service runs embedded/local desktop wrapper, local server app, or centrally hosted internal service.
1. Legacy lane lifecycle: define sunset triggers (date, risk threshold, or parity milestone) to control maintenance cost.